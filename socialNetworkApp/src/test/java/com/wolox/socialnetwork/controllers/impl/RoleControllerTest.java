package com.wolox.socialnetwork.controllers.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.wolox.socialnetwork.dto.RoleDto;
import com.wolox.socialnetwork.models.Role;
import com.wolox.socialnetwork.services.RoleService;

public class RoleControllerTest {

	@InjectMocks
	private RoleControllerImpl controller;
	
	@Mock
	private RoleService service;
	
	private Role role;
	private RoleDto roleDto;
	
	@Before
	public void initMocks() {
		role = getRole();
		roleDto = getRoleDto();
		MockitoAnnotations.initMocks(this);
	}
	
	private Role getRole() {
		return new Role(1, "escribir");
	}
	
	private RoleDto getRoleDto() {
		return new RoleDto("escribir");
	}
	
	@Test
	public void doGetAllRolesTest() {
		when(service.getAllRoles()).thenReturn(Stream.of(role).collect(Collectors.toList()));
		assertEquals(1, controller.doGetAllRoles().getBody().size());
	}

	@Test
	public void doGetRoleTest() {
		when(service.getRoleById(1)).thenReturn(role);
		assertEquals(role, controller.doGetRole(1).getBody());
	}
	
	@Test
	public void doPostRoleTest() {
		when(service.createRole(roleDto)).thenReturn(role);
		assertEquals(role, controller.doPostRole(roleDto).getBody());
	}
}
