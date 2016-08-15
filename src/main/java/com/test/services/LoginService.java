package com.test.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginService.class);
	
	/**
	 * Checks if the Username and password is correct or not
	 * @param username
	 * @param password
	 */
	public String validateUser(String username, String password){
		logger.info("Validating User,,");
		if((username.equalsIgnoreCase("admin")) && (password.equalsIgnoreCase("admin"))){
			logger.info("Admin validated!");
			return "admin";
		}else if((username.equalsIgnoreCase("test")) && (password.equalsIgnoreCase("test"))){
			logger.info("User validated!");
			return "test";
		}else{
			logger.info("User validation failed..");
			return "failure";
		}
	}
}
