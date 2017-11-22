package com.offers4u.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.offers4u.auth.controller.dto.LoginDetails;
import com.offers4u.auth.service.UserAuthService;

@RestController
@RequestMapping(path = "/api/v1/login")
public class AuthController {

	@Autowired
	UserAuthService userAuthService;
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
	public String loginUser(@RequestBody LoginDetails loginDetails){
		return userAuthService.authenticateUser(loginDetails);
	}
}