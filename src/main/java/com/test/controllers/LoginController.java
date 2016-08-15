package com.test.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.entities.User;
import com.test.services.LoginService;

@Controller
public class LoginController {
	private final LoginService loginService;
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	public LoginController(LoginService loginService){
		this.loginService = loginService;
		logger.info("Inside Login Controller...");
	}
	
	@RequestMapping(value = "/dologin", method = RequestMethod.POST, produces="text/plain")
	public @ResponseBody String doLogin(@RequestBody final User user) {
		logger.info("Inside dologin");
		
		String validateUserResponse = loginService.validateUser(user.getUsername(),user.getPassword()); 
		logger.debug(validateUserResponse);
		
		return validateUserResponse;
	}

}
