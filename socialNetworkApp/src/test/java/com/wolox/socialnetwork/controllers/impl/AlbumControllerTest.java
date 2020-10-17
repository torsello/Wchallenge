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

import com.wolox.socialnetwork.models.Album;
import com.wolox.socialnetwork.services.impl.SocialNetworkServiceImpl;

public class AlbumControllerTest {

	@InjectMocks
	private AlbumControllerImpl controller;
	
	@Mock
	private SocialNetworkServiceImpl service;
	
	private Album album;
	
	@Before
	public void initMocks() {
		album = getAlbum();
		MockitoAnnotations.initMocks(this);
	}
	
	private Album getAlbum() {
		return new Album(1, 1, "title");
	}
	
	@Test
	public void doGetAllAlbumsTest() {
		when(service.getAllAlbums()).thenReturn(Stream.of(album).collect(Collectors.toList()));
		assertEquals(1, controller.doGetAllAlbums().getBody().size());
	}

	@Test
	public void doGetAlbumTest() {
		when(service.getAlbumById(1)).thenReturn(album);
		assertEquals(album, controller.doGetAlbum(1).getBody());
	}
	
}
