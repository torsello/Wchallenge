package com.wolox.socialnetwork.services.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolox.socialnetwork.jsonplaceholder.service.impl.JsonPlaceHolderServiceImpl;
import com.wolox.socialnetwork.models.Album;
import com.wolox.socialnetwork.models.Comment;
import com.wolox.socialnetwork.models.Photo;
import com.wolox.socialnetwork.models.User;
import com.wolox.socialnetwork.services.SocialNetworkService;

@Service
public class SocialNetworkServiceImpl implements SocialNetworkService {

	@Autowired
	private JsonPlaceHolderServiceImpl jsonPlaceHolderService;
	
	private final Logger logger = LoggerFactory.getLogger(getClass().getName());

	@Override
	public List<User> getAllUsers() {
		logger.info("Getting all users from JsonPlaceHolderService");
		
		return jsonPlaceHolderService.getAllUsers();
	}

	@Override
	public User getUserById(long userId) {
		logger.info("Getting user by id from JsonPlaceHolderService");

		return jsonPlaceHolderService.getUserById(userId);
	}

	@Override
	public List<Photo> getAllPhotos() {
		logger.info("Getting all photos from JsonPlaceHolderService");

		return jsonPlaceHolderService.getAllPhotos();
	}

	@Override
	public List<Photo> getPhotosByUser(long userId) {
		logger.info("Getting all photos by user from JsonPlaceHolderService");

		return jsonPlaceHolderService.getPhotosByUser(userId);
	}

	@Override
	public Photo getPhotoById(long photoId) {
		logger.info("Getting photo by id from JsonPlaceHolderService");

		return jsonPlaceHolderService.getPhotoById(photoId);
	}

	@Override
	public List<Album> getAllAlbums() {
		logger.info("Getting all albums from JsonPlaceHolderService");

		return jsonPlaceHolderService.getAllAlbums();
	}

	@Override
	public Album getAlbumById(long albumId) {
		logger.info("Getting album by id from JsonPlaceHolderService");

		return jsonPlaceHolderService.getAlbumById(albumId);
	}

	@Override
	public List<Album> getAlbumsByUser(long userId) {
		logger.info("Getting all albums by User from JsonPlaceHolderService");

		return jsonPlaceHolderService.getAlbumsByUser(userId);
	}

	@Override
	public List<Comment> getAllComments(Optional<String> name) {

		List<Comment> comments = null;

		if (name.isPresent()) {
			logger.info("Getting all comments by Name from JsonPlaceHolderService");
			comments = jsonPlaceHolderService.getCommentsByName(name.get());
		}else {
			logger.info("Getting all comments from JsonPlaceHolderService");
			comments = jsonPlaceHolderService.getAllComments();
		}
		
		return comments;
	}

	@Override
	public List<Comment> getCommentsByUser(long userId) {
		logger.info("Getting all comments by User from JsonPlaceHolderService");

		return jsonPlaceHolderService.getCommentsByUser(userId);
	}
}
