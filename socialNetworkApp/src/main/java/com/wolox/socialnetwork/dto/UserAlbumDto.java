package com.wolox.socialnetwork.dto;

import lombok.Data;

@Data
public class UserAlbumDto {

	private long albumId;
	private long userId;
	private long roleId;

	public UserAlbumDto(long albumId, long userId, long roleId) {
		super();
		this.albumId = albumId;
		this.userId = userId;
		this.roleId = roleId;
	}

	public UserAlbumDto() {
		super();
	}

}
