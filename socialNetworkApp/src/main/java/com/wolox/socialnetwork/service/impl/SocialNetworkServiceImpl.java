package com.wolox.socialnetwork.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolox.socialnetwork.jsonplaceholder.service.impl.JsonPlaceHolderServiceImpl;
import com.wolox.socialnetwork.model.User;
import com.wolox.socialnetwork.service.SocialNetworkService;

@Service
public class SocialNetworkServiceImpl implements SocialNetworkService{

	@Autowired
	private JsonPlaceHolderServiceImpl jsonPlaceHolderService;
	
	@Override
	public List<User> getAllUsers() {

		return jsonPlaceHolderService.getAllUsers();
	}

}
