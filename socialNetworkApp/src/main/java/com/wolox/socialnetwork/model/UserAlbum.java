package com.wolox.socialnetwork.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "userAlbum")
public class UserAlbum  implements Serializable{
	
	private static final long serialVersionUID = 2558326058315712856L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userAlbumId;
	
	private long userId;
	
	@ManyToOne
	@JoinColumn(name = "roleId")
	private Role role;
	
	private long albumId;
}
