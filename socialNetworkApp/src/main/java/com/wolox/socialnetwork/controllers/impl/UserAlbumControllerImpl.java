package com.wolox.socialnetwork.controllers.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.wolox.socialnetwork.controllers.UserAlbumController;
import com.wolox.socialnetwork.dto.PatchUserAlbumDto;
import com.wolox.socialnetwork.dto.UserAlbumDto;
import com.wolox.socialnetwork.models.User;
import com.wolox.socialnetwork.models.UserAlbum;
import com.wolox.socialnetwork.services.UserAlbumService;

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

	@Override
	public ResponseEntity<List<UserAlbum>> doPatchUserAlbum(long albumId, PatchUserAlbumDto patchUserAlbumDto) {
		return new ResponseEntity<>(userAlbumService.patchUserRoleByAlbumId(albumId, patchUserAlbumDto), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<User>> doGetUsersByAlbumAndRole(long albumId, long roleId) {
		return new ResponseEntity<>(userAlbumService.getUsersByAlbumAndRole(albumId, roleId), HttpStatus.OK);
	}

}
