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

import com.wolox.socialnetwork.dto.PatchUserAlbumDto;
import com.wolox.socialnetwork.dto.UserAlbumDto;
import com.wolox.socialnetwork.models.Address;
import com.wolox.socialnetwork.models.Album;
import com.wolox.socialnetwork.models.Company;
import com.wolox.socialnetwork.models.Role;
import com.wolox.socialnetwork.models.User;
import com.wolox.socialnetwork.models.UserAlbum;
import com.wolox.socialnetwork.repositories.RoleRepository;
import com.wolox.socialnetwork.repositories.UserAlbumRepository;
import com.wolox.socialnetwork.services.SocialNetworkService;

public class UserAlbumServiceImplTest {

	private User user;
	private UserAlbum userAlbum;
	private UserAlbumDto userAlbumDto;
	private PatchUserAlbumDto patchUserAlbumDto;
	private Role role;
	private Album album;

	@InjectMocks
	private UserAlbumServiceImpl userAlbumService;

	@Mock
	private SocialNetworkService socialNetworkService;

	@Mock
	private UserAlbumRepository repository;

	@Mock
	private RoleRepository roleRepository;

	@Before
	public void initMocks() {
		user = getUser();
		userAlbum = getUserAlbum();
		userAlbumDto = getUserAlbumDto();
		role = getRole();
		album = getAlbum();
		patchUserAlbumDto = getPatchUserAlbumDto();
		MockitoAnnotations.initMocks(this);
	}

	private PatchUserAlbumDto getPatchUserAlbumDto() {
		return new PatchUserAlbumDto(1, 1);
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

	private UserAlbum getUserAlbum() {
		Role role = new Role(1, "escribir");
		return new UserAlbum(1, 1, role, 1);
	}

	private Role getRole() {
		return new Role(1, "escribir");
	}

	private UserAlbumDto getUserAlbumDto() {
		return new UserAlbumDto(1, 1, 1);
	}

	private Album getAlbum() {
		return new Album(1, 1, "title");
	}

	@Test
	public void createUserAlbumTest() {
		when(roleRepository.findByRoleId(1)).thenReturn(role);
		when(socialNetworkService.getUserById(1)).thenReturn(user);
		when(socialNetworkService.getAlbumById(1)).thenReturn(album);
		when(repository.save(userAlbum)).thenReturn(userAlbum);
		userAlbumService.createUserAlbum(userAlbumDto);
		verify(repository, times(1)).save(any(UserAlbum.class));
	}

	@Test
	public void getAllUserAlbumsTest() {
		when(repository.findAll()).thenReturn(Stream.of(userAlbum).collect(Collectors.toList()));
		assertEquals(1,  userAlbumService.getAllUserAlbums().size());
	}
	
	@Test
	public void getUserAlbumByIdTest() {
		when(repository.findByUserAlbumId(1)).thenReturn(userAlbum);
		assertEquals(userAlbum.getAlbumId(), userAlbumService.getUserAlbumById(1).getAlbumId());
	}
	
	@Test
	public void patchUserRoleByAlbumIdTest() {
		when(repository.findAllByAlbumId(1)).thenReturn(Stream.of(userAlbum).collect(Collectors.toList()));
		when(roleRepository.findByRoleId(1)).thenReturn(role);
		when(socialNetworkService.getUserById(1)).thenReturn(user);
		when(repository.save(userAlbum)).thenReturn(userAlbum);
		
		assertEquals(1, userAlbumService.patchUserRoleByAlbumId(1, patchUserAlbumDto).size());
	}
	
	@Test
	public void getUsersByAlbumAndRoleTest() {
		Long userId = 1L;
		when(roleRepository.findByRoleId(1)).thenReturn(role);
		when(repository.findAllUsersIdByAlbumAndRole(1, role)).thenReturn(Stream.of(userId).collect(Collectors.toList()));
		when(socialNetworkService.getUserById(1)).thenReturn(user);
		
		assertEquals(Stream.of(user).collect(Collectors.toList()), userAlbumService.getUsersByAlbumAndRole(1, 1));
	}
}
