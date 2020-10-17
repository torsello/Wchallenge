package com.wolox.socialnetwork.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolox.socialnetwork.models.Photo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/photos")
@Api(tags = "Photos")
public interface PhotoController {
	
	@GetMapping
	@ApiOperation(value = "List all Photos", notes = "This service returns all Photos")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Photos found"),
			@ApiResponse(code = 404, message = "Photos not found") })
	public ResponseEntity<List<Photo>> doGetAllPhotos();
	
	@GetMapping("/{photoId}")
	@ApiOperation(value = "Return photo by id", notes = "This service return photo by id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Photo found"),
			@ApiResponse(code = 404, message = "Photo not found") })
	public ResponseEntity<Photo> doGetPhoto(@PathVariable("photoId") long photoId);
	
}
