package com.wolox.socialnetwork.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolox.socialnetwork.models.Album;
import com.wolox.socialnetwork.models.Comment;
import com.wolox.socialnetwork.models.Photo;
import com.wolox.socialnetwork.models.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/users")
@Api(tags = "Users")
public interface UserController {

	@GetMapping
	@ApiOperation(value = "List all users", notes = "This service returns all users")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Users found"),
			@ApiResponse(code = 404, message = "Users not found") })
	public ResponseEntity<List<User>> doGetAllUsers();

	@GetMapping("/{userId}")
	@ApiOperation(value = "Return user by id", notes = "This service returns users by id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "User found"),
			@ApiResponse(code = 404, message = "User not found") })
	public ResponseEntity<User> doGetUser(@PathVariable("userId") long userId);
	 
	@GetMapping("/{userId}/photos")
	@ApiOperation(value = "List all photos by UserId", notes = "This service returns all photos from a user")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Photos found"),
			@ApiResponse(code = 404, message = "Photos not found") })
	public ResponseEntity<List<Photo>> doGetPhotosByUser(@PathVariable("userId") long userId);

	@GetMapping("/{userId}/albums")
	@ApiOperation(value = "List all albums by UserId", notes = "This service returns all albums from a user")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Albums found"),
			@ApiResponse(code = 404, message = "Albums not found") })
	public ResponseEntity<List<Album>> doGetAlbumsByUser(@PathVariable("userId") long userId);

	@GetMapping("/{userId}/comments")
	@ApiOperation(value = "List all comments by UserId", notes = "This service returns all comments from a user")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Comments found"),
			@ApiResponse(code = 404, message = "Comments not found") })
	public ResponseEntity<List<Comment>> doGetCommentsByUser(@PathVariable("userId") long userId);

}
