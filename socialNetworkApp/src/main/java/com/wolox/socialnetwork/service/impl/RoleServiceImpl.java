package com.wolox.socialnetwork.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolox.socialnetwork.model.Role;
import com.wolox.socialnetwork.repositories.RoleRepository;
import com.wolox.socialnetwork.service.RoleService;
import com.wolox.socialnetwork.service.dto.RoleDto;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository repository;
	
	@Override
	public Role createRole(RoleDto roleDto) {
		Role role = new Role();
		
		role.setRoleName(roleDto.getRoleName());
		
		return repository.save(role);
	}

	@Override
	public List<Role> getAllRoles() {
		return repository.findAll();
	}

	@Override
	public Role getRoleById(long roleId) {
		return repository.findByRoleId(roleId);
	}

	
}
