package com.wolox.socialnetwork.models;

import java.io.Serializable;

import lombok.Data;

@Data
public class Photo implements Serializable{

	private static final long serialVersionUID = -6667415721017540189L;

	private long id;
	private long albumId;
	private String title;
	private String url;
	private String thumbnailUrl;
	
}
