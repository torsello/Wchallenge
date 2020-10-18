package com.wolox.socialnetwork.controllers.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.wolox.socialnetwork.controllers.RoleController;
import com.wolox.socialnetwork.dto.RoleDto;
import com.wolox.socialnetwork.models.Role;
import com.wolox.socialnetwork.services.RoleService;

@RestController
public class RoleControllerImpl implements RoleController {

	@Autowired
	private RoleService roleService;

	@Override
	public ResponseEntity<List<Role>> doGetAllRoles() {
		return new ResponseEntity<>(roleService.getAllRoles(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Role> doGetRole(long roleId) {
		return new ResponseEntity<>(roleService.getRoleById(roleId), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Role> doPostRole(RoleDto roleDto) {
		return new ResponseEntity<>(roleService.createRole(roleDto), HttpStatus.CREATED);
	}

}
