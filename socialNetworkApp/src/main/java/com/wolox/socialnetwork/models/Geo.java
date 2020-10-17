package com.wolox.socialnetwork.models;

import java.io.Serializable;

import lombok.Data;

@Data
public class Geo implements Serializable{
	
	private static final long serialVersionUID = 321323401149695251L;
	
	private String lat;
	private String lng;

}
