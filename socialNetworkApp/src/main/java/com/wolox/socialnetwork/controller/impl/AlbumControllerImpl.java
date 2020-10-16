package com.wolox.socialnetwork.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.wolox.socialnetwork.controller.AlbumController;
import com.wolox.socialnetwork.model.Album;
import com.wolox.socialnetwork.service.SocialNetworkService;

@RestController
public class AlbumControllerImpl implements AlbumController{

	@Autowired
	private SocialNetworkService socialNetworkService;
	
	@Override
	public ResponseEntity<List<Album>> doGetAllAlbums() {
		return new ResponseEntity<>(socialNetworkService.getAllAlbums(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Album> doGetAlbum(long albumId) {
		return new ResponseEntity<>(socialNetworkService.getAlbumById(albumId), HttpStatus.OK);
	}

}
