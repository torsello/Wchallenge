package com.wolox.socialnetwork.models;

import java.io.Serializable;

import lombok.Data;

@Data
public class Comment implements Serializable {

	private static final long serialVersionUID = 7745538469904528149L;
	private long id;
	private long postId;
	private String name;
	private String email;
	private String body;

	public Comment(long id, long postId, String name, String email, String body) {
		super();
		this.id = id;
		this.postId = postId;
		this.name = name;
		this.email = email;
		this.body = body;
	}

	public Comment() {

	}

}
