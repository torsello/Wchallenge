package com.wolox.socialnetwork.controllers.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.wolox.socialnetwork.controllers.PhotoController;
import com.wolox.socialnetwork.models.Photo;
import com.wolox.socialnetwork.services.SocialNetworkService;

@RestController
public class PhotoControllerImpl implements PhotoController {

	@Autowired
	private SocialNetworkService socialNetworkService;

	@Override
	public ResponseEntity<List<Photo>> doGetAllPhotos() {
		return new ResponseEntity<>(socialNetworkService.getAllPhotos(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Photo> doGetPhoto(long photoId) {
		return new ResponseEntity<>(socialNetworkService.getPhotoById(photoId), HttpStatus.OK);
	}

}
