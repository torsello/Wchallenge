package com.wolox.socialnetwork.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolox.socialnetwork.model.Role;
import com.wolox.socialnetwork.service.dto.RoleDto;

@RestController
@RequestMapping("/api/roles")
public interface RoleController {

	@GetMapping
	public ResponseEntity<List<Role>> doGetAllRoles();
	
	@GetMapping("/{roleId}")
	public ResponseEntity<Role> doGetRole(@PathVariable("roleId") long roleId);
	
	@PostMapping
	public ResponseEntity<Role> doPostRole(@RequestBody RoleDto roleDto);
	
}
