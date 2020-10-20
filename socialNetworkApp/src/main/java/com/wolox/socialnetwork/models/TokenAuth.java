package com.wolox.socialnetwork.models;

import java.io.Serializable;

import lombok.Data;

@Data
public class TokenAuth implements Serializable {

	private static final long serialVersionUID = -4514993314725176857L;

	private String token;

	public TokenAuth(String token) {
		super();
		this.token = token;
	}

	public TokenAuth() {
		super();
	}

}
