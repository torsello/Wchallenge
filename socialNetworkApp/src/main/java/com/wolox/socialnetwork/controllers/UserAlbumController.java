package com.wolox.socialnetwork.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolox.socialnetwork.models.UserAlbum;
import com.wolox.socialnetwork.services.dto.UserAlbumDto;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/user_album")
@Api
public interface UserAlbumController {

	@GetMapping
	public ResponseEntity<List<UserAlbum>> doGetAllUserAlbums();
	
	@GetMapping("/{userAlbumId}")
	public ResponseEntity<UserAlbum> doGetUserAlbum(@PathVariable("userAlbumId") long userAlbumId);
	
	@PostMapping
	public ResponseEntity<UserAlbum> doPostUserAlbum(@RequestBody UserAlbumDto userAlbumDto);
	
	/*@PatchMapping
	public ResponseEntity<UserAlbum> doPatchUserAlbum(@PathVariable("userAlbumId") long userAlbumId, )*/
	
}
