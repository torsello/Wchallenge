package com.wolox.socialnetwork.dto;

import lombok.Data;

@Data
public class RoleDto {

	private String roleName;

	public RoleDto(String roleName) {
		this.roleName = roleName;
	}

	public RoleDto() {
	}

}
