package com.wolox.socialnetwork.controllers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.wolox.socialnetwork.controllers.LoginController;
import com.wolox.socialnetwork.models.TokenAuth;
import com.wolox.socialnetwork.services.LoginService;

@RestController
public class LoginControllerImpl implements LoginController {

	@Autowired
	private LoginService loginService;

	@Override
	public ResponseEntity<TokenAuth> doLogon() {
		return new ResponseEntity<>(loginService.generateToken(), HttpStatus.OK);
	}

}
