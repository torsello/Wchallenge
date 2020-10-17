package com.wolox.socialnetwork.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.wolox.socialnetwork.controller.UserAlbumController;
import com.wolox.socialnetwork.model.UserAlbum;
import com.wolox.socialnetwork.service.UserAlbumService;
import com.wolox.socialnetwork.service.dto.UserAlbumDto;

@RestController
public class UserAlbumControllerImpl implements UserAlbumController{

	@Autowired
	private UserAlbumService userAlbumService;
	
	@Override
	public ResponseEntity<List<UserAlbum>> doGetAllUserAlbums() {
		return new ResponseEntity<>(userAlbumService.getAllUserAlbums(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<UserAlbum> doGetUserAlbum(long userAlbumId) {
		return new ResponseEntity<>(userAlbumService.getUserAlbumById(userAlbumId), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<UserAlbum> doPostUserAlbum(UserAlbumDto userAlbumDto) {
		return new ResponseEntity<>(userAlbumService.createUserAlbum(userAlbumDto), HttpStatus.CREATED);
	}

}
