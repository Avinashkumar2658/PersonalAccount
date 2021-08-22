package com.myaccount.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.myaccount.daos.ConfirmationTokenRepository;
import com.myaccount.entities.ConfirmationToken;
import com.myaccount.entities.User;
import com.myaccount.response.ResponseMessage;
import com.myaccount.services.EmailSenderService;
import com.myaccount.services.UserService;

@CrossOrigin("http://localhost:4200")
@RestController
public class UsersController {

	@Autowired
	UserService userService;

	@Autowired
	ConfirmationTokenRepository confirmationTokenRepository;

	@Autowired
	EmailSenderService emailSenderService;

	@PostMapping("/createUser")
	public ResponseEntity<ResponseMessage> createUser(@RequestBody User user) {
		Optional<User> existingUser = userService.findByUserName(user.getUserName());
		if (existingUser.isPresent())
			return ResponseEntity.status(HttpStatus.FOUND).body(new ResponseMessage("user name already exists"));

		User existingUserWithEmailId = userService.findByEmailIdIgnoreCase(user.getRecoveryEmail());
		if (existingUserWithEmailId != null)
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("email Id already exists"));
		user = userService.saveUser(user);

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseMessage("successfully created"));
	}

	@GetMapping("/netAmount/{userId}")
	public List<Object> findNetAmountByUserId(@PathVariable Long userId) {
		return userService.findNetAmountByUserId(userId);
	}

	@GetMapping("/user/{userId}")
	public Optional<User> findUserByUserId(@PathVariable Long userId) {
		return userService.findUserById(userId);
	}

	@PutMapping("/update_profile_photo/{userId}")
	public void updateProfilePhoto(@PathVariable Long userId,
			@RequestPart(value = "profilePhoto", required = false) MultipartFile profilePhoto) throws IOException {
		userService.updateProfilePhoto(userId, profilePhoto);
	}

	@PutMapping("/user_update")
	public void updateUser(@RequestBody User user) {
		userService.updateUser(user);
		;
	}

	@GetMapping("/profile_photo/{userId}")
	public List<Object> findProfilePhotoByUserId(@PathVariable Long userId) {
		return userService.findProfile_photoByUSerId(userId);
	}

	@PostMapping("/forgot-password")
	public ResponseEntity<ResponseMessage> forgotUserPassword(@RequestBody String emailId) {
		String message = "";
		User existingUser = userService.findByEmailIdIgnoreCase(emailId);
		if (existingUser != null) {
			ConfirmationToken confirmationToken = new ConfirmationToken(existingUser.getUserId());
			confirmationTokenRepository.updateToken(confirmationToken.getConfirmationToken(),
					confirmationToken.getCreatedDate(), confirmationToken.getUserId());
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(existingUser.getRecoveryEmail());
			mailMessage.setSubject("Complete Password Reset!");
			mailMessage.setFrom("nairobley@gmail.com");
			mailMessage.setText("To complete the password reset for PersonalAccoount, please click here:/n "
					+ "http://localhost:8080/#/reset-password/" + existingUser.getRecoveryEmail() + "/"
					+ confirmationToken.getConfirmationToken() + "/" + existingUser.getUserId() + " " + "password link is valid for 10 minutes");
			emailSenderService.sendEmail(mailMessage);
			message = "Request to reset password received. Check your inbox for the reset link.";
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseMessage(message));

		} else {
			message = "This email does not exist!";
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new ResponseMessage(message));
		}
	}

	@PutMapping(value = "/reset-password/{userId}")
	public ResponseEntity<ResponseMessage> resetUserPassword(@PathVariable("userId") Long userId,
			@RequestBody String password) {
		String message = "";
		Optional<User> user = userService.findUserById(userId);
		if (user.isPresent()) {
			User user1 = user.get();
			userService.updatePassword(user1.getUserId(), password);
			message = "Password successfully reset. You can now log in with the new credentials.";
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseMessage(message));
		} else {
			message = "The link is invalid or broken!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}

	@GetMapping("/user_credential/{userId}/{pattern_url}")
	public int findUserconfirmation(@PathVariable("userId") String userId, @PathVariable("pattern_url") String pattern_url) throws ParseException {
		Long id = Long.parseLong(userId);
		return userService.findUserconfirmation(id, pattern_url);
	}
}
