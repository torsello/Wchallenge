package com.wolox.socialnetwork.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import com.wolox.socialnetwork.models.Token;
import com.wolox.socialnetwork.services.LoginService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class LoginServiceImpl implements LoginService{

	@Value("${token.secret.key}")
	public String secretKey;
	
	@Value("${token.expiration.milis:600000}")
	public long tokenDuration;
	
	@Override
	public Token generateToken() {
		Token token = new Token();
		token.setToken(getJWTToken());
		return token;
	}
	
	private String getJWTToken() {
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("USER");
		
		return Jwts
				.builder()
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + tokenDuration))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();
	}

}
