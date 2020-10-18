package com.wolox.socialnetwork.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wolox.socialnetwork.dto.RoleDto;
import com.wolox.socialnetwork.models.Role;
import com.wolox.socialnetwork.repositories.RoleRepository;
import com.wolox.socialnetwork.services.RoleService;

@Service
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService {

	private final Logger logger = LoggerFactory.getLogger(getClass().getName());

	@Autowired
	private RoleRepository repository;

	@Override
	@Transactional
	public Role createRole(RoleDto roleDto) {
		logger.info("A new Role will be created");
		Role role = new Role();

		role.setRoleName(roleDto.getRoleName());
		
		return repository.save(role);
	}

	@Override
	public List<Role> getAllRoles() {
		logger.info("Returning all Roles");

		return repository.findAll();
	}

	@Override
	public Role getRoleById(long roleId) {
		logger.info("Returning role by id");

		return repository.findByRoleId(roleId);
	}

}
