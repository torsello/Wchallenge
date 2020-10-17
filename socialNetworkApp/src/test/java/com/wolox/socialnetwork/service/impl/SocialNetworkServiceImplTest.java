package com.wolox.socialnetwork.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.wolox.socialnetwork.jsonplaceholder.service.impl.JsonPlaceHolderServiceImpl;
import com.wolox.socialnetwork.models.Address;
import com.wolox.socialnetwork.models.Company;
import com.wolox.socialnetwork.models.User;
import com.wolox.socialnetwork.services.impl.SocialNetworkServiceImpl;

public class SocialNetworkServiceImplTest {
	
	private Company company = new Company();
	
	private User user;
	
	@InjectMocks
	private SocialNetworkServiceImpl socialNetworkService;
	
	@Mock
	private JsonPlaceHolderServiceImpl jsonPlaceHolderService;
	
	@Before 
    public void initMocks() {
		user = getUser();
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
		return new User(id, name, username, email, address, phone, website, company); 
	}

	@Test
	public void getAllUsersTest() {
		when(jsonPlaceHolderService.getAllUsers()).thenReturn(Stream.of(user).collect(Collectors.toList()));
		assertEquals(1, socialNetworkService.getAllUsers().size());
	}
	
	@Test
	public void getUserByIdTest() {
		when(jsonPlaceHolderService.getUserById(1L)).thenReturn(user);
		assertEquals(user.getId(), socialNetworkService.getUserById(1L).getId());
	}
	
	

}
