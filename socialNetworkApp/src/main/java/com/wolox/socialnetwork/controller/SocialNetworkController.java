package com.wolox.socialnetwork.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolox.socialnetwork.model.User;

@RestController
@RequestMapping("/api/users")
public interface SocialNetworkController {

	@GetMapping
	public ResponseEntity<List<User>> getAllUsers();
}
