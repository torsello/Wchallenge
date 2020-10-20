package com.wolox.socialnetwork.services;

import org.springframework.stereotype.Service;

import com.wolox.socialnetwork.models.TokenAuth;

@Service
public interface LoginService {

	public TokenAuth generateToken();

}
