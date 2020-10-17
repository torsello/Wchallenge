package com.wolox.socialnetwork.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolox.socialnetwork.models.Album;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/albums")
@Api(tags = "Albums")
public interface AlbumController {
	
	@GetMapping
	@ApiOperation(value = "List all Albums", notes = "This service returns all Albums")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Albums found"),
			@ApiResponse(code = 404, message = "Albums not found") })
	public ResponseEntity<List<Album>> doGetAllAlbums();
	
	@GetMapping("/{albumId}")
	@ApiOperation(value = "Return album by id", notes = "This service returns album by id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Album found"),
			@ApiResponse(code = 404, message = "Album not found") })
	public ResponseEntity<Album> doGetAlbum(@PathVariable("albumId") long albumId);
	
}
