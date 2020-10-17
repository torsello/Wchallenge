package com.wolox.socialnetwork.models;

import java.io.Serializable;

import lombok.Data;

@Data
public class Token implements Serializable{

	private static final long serialVersionUID = -4514993314725176857L;

	private String token;

	public Token(String token) {
		super();
		this.token = token;
	}

	public Token() {
		super();
	}
	
	
}
