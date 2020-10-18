package com.wolox.socialnetwork.jsonplaceholder.service;

import java.util.List;

import com.wolox.socialnetwork.models.Album;
import com.wolox.socialnetwork.models.Comment;
import com.wolox.socialnetwork.models.Photo;
import com.wolox.socialnetwork.models.User;

public interface IJsonPlaceHolderService {

	public List<User> getAllUsers();

	public User getUserById(long userId);

	public List<Photo> getAllPhotos();

	public List<Photo> getPhotosByUser(long userId);

	public Photo getPhotoById(long photoId);

	public List<Album> getAllAlbums();

	public Album getAlbumById(long albumId);

	public List<Album> getAlbumsByUser(long userId);

	public List<Comment> getAllComments();

	public List<Comment> getCommentsByUser(long userId);

	public List<Comment> getCommentsByName(String name);

}
