package com.wolox.socialnetwork.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolox.socialnetwork.models.Token;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/login")
@Api(tags = "Login")
public interface LoginController {
	
	@GetMapping
	@ApiOperation(value = "Simulates login, returns token", notes = "This service simulates login")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully login")})
	public ResponseEntity<Token> doLogon();

}
