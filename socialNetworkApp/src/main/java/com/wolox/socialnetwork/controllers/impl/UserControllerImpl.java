package com.wolox.socialnetwork.controllers.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.wolox.socialnetwork.controllers.UserController;
import com.wolox.socialnetwork.models.Album;
import com.wolox.socialnetwork.models.Comment;
import com.wolox.socialnetwork.models.Photo;
import com.wolox.socialnetwork.models.User;
import com.wolox.socialnetwork.services.SocialNetworkService;

@RestController
public class UserControllerImpl implements UserController {

	@Autowired
	private SocialNetworkService socialNetworkService;
	
	@Override	
	public ResponseEntity<List<User>> doGetAllUsers() {
		return new ResponseEntity<>(socialNetworkService.getAllUsers(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<User> doGetUser(long userId) {
		return new ResponseEntity<>(socialNetworkService.getUserById(userId), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<Photo>> doGetPhotosByUser(long userId) {
		return new ResponseEntity<>(socialNetworkService.getPhotosByUser(userId), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<Album>> doGetAlbumsByUser(long userId) {
		return new ResponseEntity<>(socialNetworkService.getAlbumsByUser(userId), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<Comment>> doGetCommentsByUser(long userId) {
		return new ResponseEntity<>(socialNetworkService.getCommentsByUser(userId), HttpStatus.OK);
	}

}
