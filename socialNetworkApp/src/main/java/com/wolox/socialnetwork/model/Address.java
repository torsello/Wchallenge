package com.wolox.socialnetwork.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Address implements Serializable {

	private static final long serialVersionUID = 199041223503527014L;
	
	private String street;
	private String suite;
	private String city;
	private String zipcode;
	private Geo geo;
	
}
