package com.wolox.socialnetwork.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.wolox.socialnetwork.jsonplaceholder.service.impl.JsonPlaceHolderServiceImpl;
import com.wolox.socialnetwork.models.Address;
import com.wolox.socialnetwork.models.Album;
import com.wolox.socialnetwork.models.Comment;
import com.wolox.socialnetwork.models.Company;
import com.wolox.socialnetwork.models.Photo;
import com.wolox.socialnetwork.models.User;

public class SocialNetworkServiceImplTest {
	
	private static final long ID = 1L;
	
	
	private User user;
	private Photo photo;
	private Album album;
	private Comment comment;
	
	@InjectMocks
	private SocialNetworkServiceImpl socialNetworkService;
	
	@Mock
	private JsonPlaceHolderServiceImpl jsonPlaceHolderService;
	
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
	public void getAllUsersTest() {
		when(jsonPlaceHolderService.getAllUsers()).thenReturn(Stream.of(user).collect(Collectors.toList()));
		assertEquals(1, socialNetworkService.getAllUsers().size());
	}
	
	@Test
	public void getUserByIdTest() {
		when(jsonPlaceHolderService.getUserById(ID)).thenReturn(user);
		assertEquals(user.getId(), socialNetworkService.getUserById(ID).getId());
	}
	
	@Test
	public void getAllPhotosTest() {
		when(jsonPlaceHolderService.getAllPhotos()).thenReturn(Stream.of(photo).collect(Collectors.toList()));
		assertEquals(1, socialNetworkService.getAllPhotos().size());
	}
	
	@Test
	public void getPhotosByUserTest() {
		when(jsonPlaceHolderService.getPhotosByUser(ID)).thenReturn(Stream.of(photo).collect(Collectors.toList()));
		assertEquals(1, socialNetworkService.getPhotosByUser(ID).size());
	}
	
	@Test
	public void getPhotoByIdTest() {
		when(jsonPlaceHolderService.getPhotoById(ID)).thenReturn(photo);
		assertEquals(photo.getId(), socialNetworkService.getPhotoById(ID).getId());
	}
	
	@Test
	public void getAllAlbumsTest() {
		when(jsonPlaceHolderService.getAllAlbums()).thenReturn(Stream.of(album).collect(Collectors.toList()));
		assertEquals(1, socialNetworkService.getAllAlbums().size());
	}
	
	@Test
	public void getAlbumsByUserTest() {
		when(jsonPlaceHolderService.getAlbumsByUser(ID)).thenReturn(Stream.of(album).collect(Collectors.toList()));
		assertEquals(1, socialNetworkService.getAlbumsByUser(ID).size());
	}
	
	@Test
	public void getAlbumByIdTest() {
		when(jsonPlaceHolderService.getAlbumById(ID)).thenReturn(album);
		assertEquals(album.getId(), socialNetworkService.getAlbumById(ID).getId());
	}
	
	@Test
	public void getAllCommentsTest() {
		String nullName = null;
		String name = "name";
	    Optional<String> optNullName = Optional.ofNullable(nullName);
	    Optional<String> optName = Optional.of(name);
		
		when(jsonPlaceHolderService.getCommentsByName(name)).thenReturn(Stream.of(comment).collect(Collectors.toList()));
		assertEquals(1, socialNetworkService.getAllComments(optName).size());
		
		when(jsonPlaceHolderService.getAllComments()).thenReturn(Stream.of(comment).collect(Collectors.toList()));
		assertEquals(1, socialNetworkService.getAllComments(optNullName).size());
	}
	
	@Test
	public void getCommentsByUserTest() {
		when(jsonPlaceHolderService.getCommentsByUser(ID)).thenReturn(Stream.of(comment).collect(Collectors.toList()));
		assertEquals(1, socialNetworkService.getCommentsByUser(ID).size());
	}
	
	

}
