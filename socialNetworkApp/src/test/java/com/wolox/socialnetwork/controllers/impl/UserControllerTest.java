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

import com.wolox.socialnetwork.models.Address;
import com.wolox.socialnetwork.models.Album;
import com.wolox.socialnetwork.models.Comment;
import com.wolox.socialnetwork.models.Company;
import com.wolox.socialnetwork.models.Photo;
import com.wolox.socialnetwork.models.User;
import com.wolox.socialnetwork.services.impl.SocialNetworkServiceImpl;

public class UserControllerTest {

	@InjectMocks
	private UserControllerImpl controller;
	
	@Mock
	private SocialNetworkServiceImpl service;
	
	private User user;
	private Photo photo;
	private Album album;
	private Comment comment;
	
	@Before 
    public void initMocks() {
		user = getUser();
		photo = getPhoto();
		album = getAlbum();
		comment = getComment();
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
	
	private Photo getPhoto() {
		return new Photo(1, 1, "title", "url", "thumbnailUrl");
	}
	
	private Album getAlbum() {
		return new Album(1, 1, "title");
	}
	
	private Comment getComment() {
		return new Comment(1, 1, "name", "email", "body");
	}
	
	@Test
	public void doGetAllUsers() {
		when(service.getAllUsers()).thenReturn(Stream.of(user).collect(Collectors.toList()));
		assertEquals(1, controller.doGetAllUsers().getBody().size());
	}
	
	@Test
	public void doGetUser() {
		when(service.getUserById(1)).thenReturn(user);
		assertEquals(user, controller.doGetUser(1).getBody());
	}
	
	@Test
	public void doGetPhotosByUser() {
		when(service.getPhotosByUser(1)).thenReturn(Stream.of(photo).collect(Collectors.toList()));
		assertEquals(1, controller.doGetPhotosByUser(1).getBody().size());
	}
	
	@Test
	public void doGetAlbumsByUser() {
		when(service.getAlbumsByUser(1)).thenReturn(Stream.of(album).collect(Collectors.toList()));
		assertEquals(1, controller.doGetAlbumsByUser(1).getBody().size());
	}
	
	@Test
	public void doGetCommentsByUser() {
		when(service.getCommentsByUser(1)).thenReturn(Stream.of(comment).collect(Collectors.toList()));
		assertEquals(1, controller.doGetCommentsByUser(1).getBody().size());
	}
	
}
