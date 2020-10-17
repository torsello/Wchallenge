package com.wolox.socialnetwork.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wolox.socialnetwork.model.UserAlbum;
import com.wolox.socialnetwork.service.dto.UserAlbumDto;

@Service
public interface UserAlbumService {

	public UserAlbum createUserAlbum(UserAlbumDto userAlbumDto);
	
	public List<UserAlbum> getAllUserAlbums();
	
	public UserAlbum getUserAlbumById(long userAlbumId);
}
