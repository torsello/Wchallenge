package com.wolox.socialnetwork.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.wolox.socialnetwork.controller.SocialNetworkController;
import com.wolox.socialnetwork.model.User;
import com.wolox.socialnetwork.service.SocialNetworkService;

@RestController
public class SocialNetworkControllerImpl implements SocialNetworkController{

	@Autowired
	private SocialNetworkService socialNetworkService;
	
	@Override	
	public ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<>(socialNetworkService.getAllUsers(), HttpStatus.OK);
	}

}
