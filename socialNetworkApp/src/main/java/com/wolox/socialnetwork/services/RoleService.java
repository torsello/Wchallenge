package com.wolox.socialnetwork.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wolox.socialnetwork.dto.RoleDto;
import com.wolox.socialnetwork.models.Role;

@Service
public interface RoleService {

	public Role createRole(RoleDto roleDto);
	
	public List<Role> getAllRoles();
	
	public Role getRoleById(long roleId);
}
