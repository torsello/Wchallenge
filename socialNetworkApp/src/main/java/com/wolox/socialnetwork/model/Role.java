package com.wolox.socialnetwork.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "role")
public class Role implements Serializable{

	private static final long serialVersionUID = -5571066707799785797L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long roleId;
	private String roleName;
	
}
