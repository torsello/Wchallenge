package com.wolox.socialnetwork.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wolox.socialnetwork.models.UserAlbum;
import com.wolox.socialnetwork.services.dto.UserAlbumDto;

@Service
public interface UserAlbumService {

	public UserAlbum createUserAlbum(UserAlbumDto userAlbumDto);
	
	public List<UserAlbum> getAllUserAlbums();
	
	public UserAlbum getUserAlbumById(long userAlbumId);
}
