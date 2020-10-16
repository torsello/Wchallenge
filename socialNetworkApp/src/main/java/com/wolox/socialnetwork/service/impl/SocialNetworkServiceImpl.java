package com.wolox.socialnetwork.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolox.socialnetwork.jsonplaceholder.service.impl.JsonPlaceHolderServiceImpl;
import com.wolox.socialnetwork.model.Album;
import com.wolox.socialnetwork.model.Comments;
import com.wolox.socialnetwork.model.Photo;
import com.wolox.socialnetwork.model.User;
import com.wolox.socialnetwork.service.SocialNetworkService;

@Service
public class SocialNetworkServiceImpl implements SocialNetworkService{

	@Autowired
	private JsonPlaceHolderServiceImpl jsonPlaceHolderService;
	
	@Override
	public List<User> getAllUsers() {
		return jsonPlaceHolderService.getAllUsers();
	}

	@Override
	public User getUserById(long userId) {
		return jsonPlaceHolderService.getUserById(userId);
	}

	@Override
	public List<Photo> getAllPhotos() {
		return jsonPlaceHolderService.getAllPhotos();
	}

	@Override
	public List<Photo> getPhotosByUser(long userId) {
		return jsonPlaceHolderService.getPhotosByUser(userId);
	}

	@Override
	public Photo getPhotoById(long photoId) {
		return jsonPlaceHolderService.getPhotoById(photoId);
	}

	@Override
	public List<Album> getAllAlbums() {
		return jsonPlaceHolderService.getAllAlbums();
	}

	@Override
	public Album getAlbumById(long albumId) {
		return jsonPlaceHolderService.getAlbumById(albumId);
	}

	@Override
	public List<Album> getAlbumsByUser(long userId) {
		return jsonPlaceHolderService.getAlbumsByUser(userId);
	}

	@Override
	public List<Comments> getAllComments() {
		return jsonPlaceHolderService.getAllComments();
	}

	@Override
	public List<Comments> getCommentsByUser(long userId) {
		return jsonPlaceHolderService.getCommentsByUser(userId);
	}

	@Override
	public List<Comments> getCommentsByName(String name) {
		return jsonPlaceHolderService.getCommentsByName(name);
	}

}
