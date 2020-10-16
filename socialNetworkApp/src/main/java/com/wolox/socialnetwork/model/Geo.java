package com.wolox.socialnetwork.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Geo implements Serializable{
	
	private static final long serialVersionUID = 321323401149695251L;
	
	private String lat;
	private String lng;

}
