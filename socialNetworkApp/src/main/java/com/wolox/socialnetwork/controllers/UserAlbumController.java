package com.wolox.socialnetwork.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolox.socialnetwork.dto.PatchUserAlbumDto;
import com.wolox.socialnetwork.dto.UserAlbumDto;
import com.wolox.socialnetwork.models.User;
import com.wolox.socialnetwork.models.UserAlbum;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/user_album")
@Api(tags = "UserAlbum")
public interface UserAlbumController {

	@GetMapping
	@ApiOperation(value = "List all UserAlbums", notes = "This service returns all UserAlbum")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "UserAlbums found"),
			@ApiResponse(code = 404, message = "UserAlbums not found") })
	public ResponseEntity<List<UserAlbum>> doGetAllUserAlbums();
	
	@GetMapping("/{userAlbumId}")
	@ApiOperation(value = "List UserAlbum by UserAlbumId", notes = "This service returns UserAlbum by Id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "UserAlbum found"),
			@ApiResponse(code = 404, message = "UserAlbum not found") })
	public ResponseEntity<UserAlbum> doGetUserAlbum(@PathVariable("userAlbumId") long userAlbumId);
	
	@PostMapping
	@ApiOperation(value = "Register an album shared with a user and their permissions", notes = "This service creates a UserAlbum")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "UserAlbum created") })
	public ResponseEntity<UserAlbum> doPostUserAlbum(@RequestBody UserAlbumDto userAlbumDto);
	
	@PatchMapping("/album/{albumId}")
	@ApiOperation(value = "Change a user's permissions for a specific album", notes = "This service update UsersAlbums")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Users found"),
			@ApiResponse(code = 404, message = "Users not found") })
	public ResponseEntity<List<UserAlbum>> doPatchUserAlbum(@PathVariable("albumId") long albumId, @RequestBody PatchUserAlbumDto patchUserAlbumDto);
	
	@GetMapping("/album/{albumId}/role/{roleId}")
	@ApiOperation(value = "Return all users who have a specific permission regarding a specific album", notes = "This service returns a list of Users")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Users found") })
	public ResponseEntity<List<User>> doGetUsersByAlbumAndRole(@PathVariable("albumId") long albumId, @PathVariable("roleId") long roleId);
	
}
