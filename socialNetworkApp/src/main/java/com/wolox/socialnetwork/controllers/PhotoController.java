package com.wolox.socialnetwork.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolox.socialnetwork.models.Photo;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/photos")
@Api
public interface PhotoController {
	
	@GetMapping
	public ResponseEntity<List<Photo>> doGetAllPhotos();
	
	@GetMapping("/{photoId}")
	public ResponseEntity<Photo> doGetPhoto(@PathVariable("photoId") long photoId);
	
}
