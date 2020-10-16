package com.wolox.socialnetwork.jsonplaceholder.service;

import java.util.List;

import com.wolox.socialnetwork.model.Album;
import com.wolox.socialnetwork.model.Photo;
import com.wolox.socialnetwork.model.User;

public interface IJsonPlaceHolderService {

	
	public List<User> getAllUsers();
	
	public User getUserById(long userId);
	
	public List<Photo> getAllPhotos();
	
	public Photo getPhotoById(long photoId);
	
	public List<Album> getAllAlbums();
	
	public Album getAlbumById(long albumId);
	
	public List<Album> getAlbumsByUser(long userId);
	
	
}
