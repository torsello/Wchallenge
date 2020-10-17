package com.wolox.socialnetwork.models;

import java.io.Serializable;

import lombok.Data;

@Data
public class Company implements Serializable{

	private static final long serialVersionUID = -6072098502579343776L;
	
	private String name;
	private String catchPhrase;
	private String bs;
	
}
