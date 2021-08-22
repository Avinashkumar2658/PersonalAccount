package com.myaccount.services;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.myaccount.daos.ConfirmationTokenRepository;
import com.myaccount.daos.UserDao;
import com.myaccount.entities.ConfirmationToken;
import com.myaccount.entities.User;

@Service
public class UserService {

	@Autowired
	UserDao userRepository;

	@Autowired
	EmailSenderService emailSenderService;
	
	
	@Autowired
	ConfirmationTokenRepository confirmationTokenRepository;

	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	public User saveUser(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
		User user1 = findByEmailIdIgnoreCase(user.getRecoveryEmail());
		ConfirmationToken confirmationToken = new ConfirmationToken(user1.getUserId());
		confirmationTokenRepository.save(confirmationToken);
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(user.getRecoveryEmail());
		mailMessage.setSubject("Complete Registration!");
		mailMessage.setFrom("nairobley@gmail.com");
		mailMessage.setText("You are registered with Personal Bank Account now you use it with this emaid id if you are not then reply me");
		emailSenderService.sendEmail(mailMessage);
		return user;

	}

	public void updateUser(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.updateUser(user.getPassword(), user.getRecoveryEmail(), user.getName(), user.getAddress(),
				user.getMobileNo(), user.getUserId());
	}

	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
	}

	public Optional<User> findUserById(Long userId) {
		return userRepository.findById(userId);
	}

	public Optional<User> findByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	public List<Object> findNetAmountByUserId(Long userId) {
		return userRepository.findTotalAmountByUserId(userId);
	}

	public void updateAmount(Long userId, float amount) {
		userRepository.updateAmount(userId, amount);
	}

	public void updateProfilePhoto(Long userId, MultipartFile profilePhoto) throws IOException {
		userRepository.updateProfilePhoto(userId, profilePhoto.getBytes());
	}

	public List<Object> findProfile_photoByUSerId(Long userId) {
		return userRepository.findProfile_photoByUserId(userId);
	}

	public User findByEmailIdIgnoreCase(String emailId) {
		return userRepository.findByRecoveryEmailIgnoreCase(emailId);
	}
	
	public void updatePassword(Long userId, String password) {
		userRepository.updatePassword(userId, encoder.encode(password));
	}

	public int findUserconfirmation(Long userId, String pattern_url) throws ParseException {
		int cond  = 0;
		ConfirmationToken confirmationToken = confirmationTokenRepository.findByUserId(userId);
		if(!(pattern_url.equals(confirmationToken.getConfirmationToken())))
			return cond;
		String  date[]  = String.valueOf(confirmationToken.getCreatedDate()).split("\\.");
		Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date[0].trim());
		long MILLIS_PER_Two_DAY = 10 * 60 * 1000L;
	    Long l = date1.getTime();
	    Long now = new Date().getTime();
	    if(now - l<= MILLIS_PER_Two_DAY) 
			cond =  1;
	    return cond;
	}
}
