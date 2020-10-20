package com.wolox.socialnetwork.controllers.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.wolox.socialnetwork.models.TokenAuth;
import com.wolox.socialnetwork.services.impl.LoginServiceImpl;

public class LoginServiceTest {

	@InjectMocks
	private LoginControllerImpl controller;
	
	@Mock
	private LoginServiceImpl service;
	
	private TokenAuth token;
	
	@Before
	public void initMocks() {
		token = getToken();
		MockitoAnnotations.initMocks(this);
	}
	
	private TokenAuth getToken() {
		return new TokenAuth("1234");
	}
	
	@Test
	public void doLogonTest() {
		when(service.generateToken()).thenReturn(token);
		assertEquals(token, controller.doLogon().getBody());
	}
}
