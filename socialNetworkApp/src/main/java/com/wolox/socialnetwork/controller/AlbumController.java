package com.wolox.socialnetwork.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolox.socialnetwork.model.Album;

@RestController
@RequestMapping("/api/albums")
public interface AlbumController {
	
	@GetMapping
	public ResponseEntity<List<Album>> doGetAllAlbums();
	
	@GetMapping("/{albumId}")
	public ResponseEntity<Album> doGetAlbum(@PathVariable("albumId") long albumId);
	
}
