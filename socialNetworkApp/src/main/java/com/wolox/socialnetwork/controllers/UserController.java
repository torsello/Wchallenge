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

@RestController
@RequestMapping("/api/users")
@Api
public interface UserController {

	@GetMapping
	public ResponseEntity<List<User>> doGetAllUsers();
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> doGetUser(@PathVariable("userId") long userId);
	
	@GetMapping("/{userId}/photos")
	public ResponseEntity<List<Photo>> doGetPhotosByUser(@PathVariable("userId") long userId);
	
	@GetMapping("/{userId}/albums")
	public ResponseEntity<List<Album>> doGetAlbumsByUser(@PathVariable("userId") long userId);
	
	@GetMapping("/{userId}/comments")
	public ResponseEntity<List<Comment>> doGetCommentsByUser(@PathVariable("userId") long userId);

}
