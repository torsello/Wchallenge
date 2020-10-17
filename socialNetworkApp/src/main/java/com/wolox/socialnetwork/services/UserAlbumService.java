package com.wolox.socialnetwork.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wolox.socialnetwork.dto.PatchUserAlbumDto;
import com.wolox.socialnetwork.dto.UserAlbumDto;
import com.wolox.socialnetwork.models.User;
import com.wolox.socialnetwork.models.UserAlbum;

@Service
public interface UserAlbumService {

	public UserAlbum createUserAlbum(UserAlbumDto userAlbumDto);
	
	public List<UserAlbum> getAllUserAlbums();
	
	public UserAlbum getUserAlbumById(long userAlbumId);
	
	public List<UserAlbum> patchUserRoleByAlbumId(long albumId, PatchUserAlbumDto patchUserAlbumDto);
	
	public List<User> getUsersByAlbumAndRole(long albumId, long roleId);
}
