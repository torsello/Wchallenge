package com.wolox.socialnetwork.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolox.socialnetwork.model.Photo;

@RestController
@RequestMapping("/api/photos")
public interface PhotoController {
	
	@GetMapping
	public ResponseEntity<List<Photo>> doGetAllPhotos();
	
	@GetMapping("/{photoId}")
	public ResponseEntity<Photo> doGetPhoto(@PathVariable("photoId") long photoId);
	
}
