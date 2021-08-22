package com.myaccount.controllers;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myaccount.entities.User;
import com.myaccount.security.AuthenticationBean;
import com.myaccount.services.UserService;

@CrossOrigin("http://localhost:4200")
@RestController
public class AuthController {

	@Autowired
	UserService userService;


	@GetMapping("/user/basicauth")
	public AuthenticationBean getAuthentionMesage(Principal principal) {
		Optional<User> optUser = userService.findByUserName(principal.getName());
		User user = optUser.get();
		AuthenticationBean ab = new AuthenticationBean(user.getUserId());
		return ab;
	}



}
