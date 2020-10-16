package com.wolox.socialnetwork.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolox.socialnetwork.model.Album;
import com.wolox.socialnetwork.model.Comments;
import com.wolox.socialnetwork.model.Photo;
import com.wolox.socialnetwork.model.User;

@RestController
@RequestMapping("/api/users")
public interface UsersController {

	@GetMapping
	public ResponseEntity<List<User>> doGetAllUsers();
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> doGetUser(@PathVariable("userId") long userId);
	
	@GetMapping("/{userId}/photos")
	public ResponseEntity<List<Photo>> doGetPhotosByUser(@PathVariable("userId") long userId);
	
	@GetMapping("/{userId}/albums")
	public ResponseEntity<List<Album>> doGetAlbumsByUser(@PathVariable("userId") long userId);
	
	@GetMapping("/{userId}/comments")
	public ResponseEntity<List<Comments>> doGetCommentsByUser(@PathVariable("userId") long userId);
	
	
	
}
