package com.wolox.socialnetwork.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wolox.socialnetwork.models.Role;
import com.wolox.socialnetwork.services.dto.RoleDto;

@Service
public interface RoleService {

	public Role createRole(RoleDto roleDto);
	
	public List<Role> getAllRoles();
	
	public Role getRoleById(long roleId);
}
