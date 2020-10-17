package com.wolox.socialnetwork.controllers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.wolox.socialnetwork.controllers.LoginController;
import com.wolox.socialnetwork.models.Token;
import com.wolox.socialnetwork.services.LoginService;

@RestController
public class LoginControllerImpl implements LoginController{

	@Autowired
	private LoginService loginService;
	
	@Override
	public ResponseEntity<Token> doLogon() {
		return new ResponseEntity<>(loginService.generateToken(), HttpStatus.OK);
	}

}
