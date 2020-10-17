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

import com.wolox.socialnetwork.models.Photo;
import com.wolox.socialnetwork.services.impl.SocialNetworkServiceImpl;

public class PhotoControllerTest {

	@InjectMocks
	private PhotoControllerImpl controller;
	
	@Mock
	private SocialNetworkServiceImpl service;
	
	private Photo photo;
	
	@Before
	public void initMocks() {
		photo = getPhoto();
		MockitoAnnotations.initMocks(this);
	}
	
	private Photo getPhoto() {
		return new Photo(1, 1, "title", "url", "thumbnailUrl");
	}
	
	@Test
	public void doGetAllPhotosTest() {
		when(service.getAllPhotos()).thenReturn(Stream.of(photo).collect(Collectors.toList()));
		assertEquals(1, controller.doGetAllPhotos().getBody().size());
	}

	@Test
	public void doGetPhotoTest() {
		when(service.getPhotoById(1)).thenReturn(photo);
		assertEquals(photo, controller.doGetPhoto(1).getBody());
	}
}
