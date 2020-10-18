package com.wolox.socialnetwork.dto;

import lombok.Data;

@Data
public class PatchUserAlbumDto {

	private long roleId;
	private long userId;

	public PatchUserAlbumDto(long roleId, long userId) {
		super();
		this.roleId = roleId;
		this.userId = userId;
	}

	public PatchUserAlbumDto() {
		super();
	}

}
