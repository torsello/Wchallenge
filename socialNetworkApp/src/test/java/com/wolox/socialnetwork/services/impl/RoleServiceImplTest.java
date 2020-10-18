package com.wolox.socialnetwork.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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
import com.wolox.socialnetwork.repositories.RoleRepository;

public class RoleServiceImplTest {

	@InjectMocks
	private RoleServiceImpl roleService;
	
	@Mock
	private RoleRepository repository;
	
	private Role role;
	private RoleDto roleDto;
	
	@Before
	public void initMocks() {
		role = getRole();
		roleDto = getRoleDto();
		MockitoAnnotations.initMocks(this);
	}
	
	public Role getRole() {
		return new Role(1, "escribir");
	}
	
	public RoleDto getRoleDto() {
		return new RoleDto("escribir");
	}
	
	@Test
	public void createRoleTest() {
		when(repository.save(role)).thenReturn(role);
		roleService.createRole(roleDto);
		verify(repository, times(1)).save(any(Role.class));
	}

	@Test
	public void getAllRolesTest() {
		
		when(repository.findAll()).thenReturn(Stream.of(role).collect(Collectors.toList()));
		
		assertEquals(1, roleService.getAllRoles().size());
	}

	@Test
	public void getRoleByIdTest() {
		when(repository.findByRoleId(1)).thenReturn(role);
		
		assertEquals(role, roleService.getRoleById(1));
	}
}
