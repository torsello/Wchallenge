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

import com.wolox.socialnetwork.dto.PatchUserAlbumDto;
import com.wolox.socialnetwork.dto.UserAlbumDto;
import com.wolox.socialnetwork.models.Address;
import com.wolox.socialnetwork.models.Company;
import com.wolox.socialnetwork.models.Role;
import com.wolox.socialnetwork.models.User;
import com.wolox.socialnetwork.models.UserAlbum;
import com.wolox.socialnetwork.services.UserAlbumService;

public class UserAlbumControllerTest {

	@InjectMocks
	private UserAlbumControllerImpl controller;
	
	@Mock
	private UserAlbumService service;
	
	private UserAlbum userAlbum;
	private Role role;
	private UserAlbumDto userAlbumDto;
	private PatchUserAlbumDto patchUserAlbumDto;
	private User user;
	
	@Before
	public void initMocks() {
		userAlbum = getUserAlbum();
		userAlbumDto = getUserAlbumDto();
		user = getUser();
		role = getRole();
		patchUserAlbumDto = getPatchUserAlbumDto();
		MockitoAnnotations.initMocks(this);
	}
	
	private User getUser() {
		long id = 1;
		String name = "Matias";
		String username = "torsello";
		String email = "matiastorsello@gmail.com";
		Address address = new Address();
		String phone = "1121841312";
		String website = "www.matiastorsello.com";
		Company company = new Company();
		return new User(id, name, username, email, address, phone, website, company);
	}
	
	private PatchUserAlbumDto getPatchUserAlbumDto() {
		return new PatchUserAlbumDto(1, 1);
	}
	
	private Role getRole() {
		return new Role(1, "escribir");
	}
	
	private UserAlbum getUserAlbum() {
		return new UserAlbum(1, 1, role, 1);
	}
	
	private UserAlbumDto getUserAlbumDto() {
		return new UserAlbumDto(1, 1, 1);
	}
	
	@Test
	public void doGetAllUserAlbumsTest() {
		when(service.getAllUserAlbums()).thenReturn(Stream.of(userAlbum).collect(Collectors.toList()));
		assertEquals(1, controller.doGetAllUserAlbums().getBody().size());
	}

	@Test
	public void doGetUserAlbumTest() {
		when(service.getUserAlbumById(1)).thenReturn(userAlbum);
		assertEquals(userAlbum, controller.doGetUserAlbum(1).getBody());
	}
	
	@Test
	public void doPostUserAlbumTest() {
		when(service.createUserAlbum(userAlbumDto)).thenReturn(userAlbum);
		assertEquals(userAlbum, controller.doPostUserAlbum(userAlbumDto).getBody());
	}
	
	@Test
	public void doPatchUserAlbumTest() {
		when(service.patchUserRoleByAlbumId(1, patchUserAlbumDto)).thenReturn(Stream.of(userAlbum).collect(Collectors.toList()));
		assertEquals(1, controller.doPatchUserAlbum(1, patchUserAlbumDto).getBody().size());
	}
	
	@Test
	public void doGetUsersByAlbumAndRole() {
		when(service.getUsersByAlbumAndRole(1, 1)).thenReturn(Stream.of(user).collect(Collectors.toList()));
		assertEquals(1, controller.doGetUsersByAlbumAndRole(1, 1).getBody().size());
	}
	
}
