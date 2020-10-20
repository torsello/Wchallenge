package com.wolox.socialnetwork.services.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.wolox.socialnetwork.models.TokenAuth;
import com.wolox.socialnetwork.services.LoginService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class LoginServiceImpl implements LoginService {

	private final Logger logger = LoggerFactory.getLogger(getClass().getName());

	@Value("${token.secret.key}")
	private String secretKey;

	@Value("${token.expiration.milis:600000}")
	private long tokenDuration;

	@Override
	public TokenAuth generateToken() {
		logger.info("Login will be performed");
		TokenAuth token = new TokenAuth();
		token.setToken(getJWTToken());
		logger.info("Login done");
		return token;
	}

	private String getJWTToken() {

		return Jwts.builder()
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + tokenDuration))
				.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();
	}

}
