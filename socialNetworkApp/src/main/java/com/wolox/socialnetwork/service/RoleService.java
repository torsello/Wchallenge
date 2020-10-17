package com.wolox.socialnetwork.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wolox.socialnetwork.model.Role;
import com.wolox.socialnetwork.service.dto.RoleDto;

@Service
public interface RoleService {

	public Role createRole(RoleDto roleDto);
	
	public List<Role> getAllRoles();
	
	public Role getRoleById(long roleId);
}
