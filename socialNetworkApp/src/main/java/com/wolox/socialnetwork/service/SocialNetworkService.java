package com.wolox.socialnetwork.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wolox.socialnetwork.model.User;

@Service
public interface SocialNetworkService {

	public List<User> getAllUsers();
	
}
