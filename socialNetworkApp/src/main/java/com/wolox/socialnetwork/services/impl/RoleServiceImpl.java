package com.wolox.socialnetwork.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wolox.socialnetwork.dto.RoleDto;
import com.wolox.socialnetwork.models.Role;
import com.wolox.socialnetwork.repositories.RoleRepository;
import com.wolox.socialnetwork.services.RoleService;

@Service
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository repository;
	
	@Override
	@Transactional
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
