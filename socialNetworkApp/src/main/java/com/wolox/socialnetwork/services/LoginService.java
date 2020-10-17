package com.wolox.socialnetwork.services;

import org.springframework.stereotype.Service;

import com.wolox.socialnetwork.models.Token;

@Service
public interface LoginService {
	
	public Token generateToken();

}
