package com.myaccount.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.myaccount.entities.User;
import com.myaccount.services.UserService;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserService userService;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<User> user = userService.findByUserName(userName);
		user.orElseThrow(() -> new UsernameNotFoundException("Not Found : " + userName));
		MyUserDetails userDetails = new MyUserDetails(user.get());
		return userDetails;
	}
	
	

}
