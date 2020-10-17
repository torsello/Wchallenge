package com.wolox.socialnetwork.controllers.impl;

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

import com.wolox.socialnetwork.models.Comment;
import com.wolox.socialnetwork.services.impl.SocialNetworkServiceImpl;

public class CommentControllerTest {

	@InjectMocks
	private CommentControllerImpl controller;
	
	@Mock
	private SocialNetworkServiceImpl service;
	
	private Comment comment;
	
	@Before
	public void initMocks() {
		comment = getComment();
		MockitoAnnotations.initMocks(this);
	}
	
	private Comment getComment() {
		return new Comment(1, 1, "name", "email", "body");
	}
	
	@Test
	public void doGetAllCommentsTest() {
		String name = "matias";
		String nameNull = null;
		
		Optional<String> optNull = Optional.ofNullable(nameNull);
		Optional<String> opt = Optional.ofNullable(name);

		when(service.getAllComments(optNull)).thenReturn(Stream.of(comment).collect(Collectors.toList()));
		assertEquals(1, controller.doGetAllComments(optNull).getBody().size());
		when(service.getAllComments(opt)).thenReturn(Stream.of(comment).collect(Collectors.toList()));
		assertEquals(1, controller.doGetAllComments(opt).getBody().size());
	}
}
