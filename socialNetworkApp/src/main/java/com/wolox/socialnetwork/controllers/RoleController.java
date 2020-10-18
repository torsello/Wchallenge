package com.wolox.socialnetwork.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolox.socialnetwork.dto.RoleDto;
import com.wolox.socialnetwork.models.Role;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/roles")
@Api(tags = "Roles")
public interface RoleController {

	@GetMapping
	@ApiOperation(value = "List all Roles", notes = "This service returns all Roles")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Roles found"),
			@ApiResponse(code = 404, message = "Roles not found") })
	public ResponseEntity<List<Role>> doGetAllRoles();

	@GetMapping("/{roleId}")
	@ApiOperation(value = "Return a role by id", notes = "This service returns a Role")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Role found"),
			@ApiResponse(code = 404, message = "Rolesnot found") })
	public ResponseEntity<Role> doGetRole(@PathVariable("roleId") long roleId);

	@PostMapping
	@ApiOperation(value = "Creates a new Role", notes = "This service creates a role")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Role created") })
	public ResponseEntity<Role> doPostRole(@RequestBody RoleDto roleDto);

}
