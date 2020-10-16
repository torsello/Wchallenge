package com.wolox.socialnetwork.jsonplaceholder.service.impl;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wolox.socialnetwork.exception.JsonPlaceHolderServiceException;
import com.wolox.socialnetwork.exception.ResponseServiceException;
import com.wolox.socialnetwork.jsonplaceholder.JsonPlaceHolderClient;
import com.wolox.socialnetwork.jsonplaceholder.service.IJsonPlaceHolderService;
import com.wolox.socialnetwork.model.Album;
import com.wolox.socialnetwork.model.Photo;
import com.wolox.socialnetwork.model.User;

import okhttp3.Request;
import okhttp3.Response;

@Service
public class JsonPlaceHolderServiceImpl implements IJsonPlaceHolderService {

	private static final String USERS = "/users";
	private static final String PHOTOS = "/photos";
	private static final String ALBUMS = "/albums";
	
	@Autowired
	private JsonPlaceHolderClient client;

	@Value("${jsonPlaceHolder.host}")
	private String host;

	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		Request request = new Request.Builder().url(host + USERS).build();
		
		try {
			Response response = client.getNewJsonPlaceHolderClient().newCall(request).execute();
			
			if(!response.isSuccessful()) {
				throw new ResponseServiceException(response.code(), response.message());
			}
			
			Type userList = new TypeToken<ArrayList<User>>(){}.getType();
			String responseBody = response.body().string();
			users = new Gson().fromJson(responseBody, userList);
		} catch (IOException e) {
			throw new JsonPlaceHolderServiceException("GET - allUsers");
		}

		return users;
	}

	@Override
	public User getUserById(long userId) {
		User user = new User();
		Request request = new Request.Builder().url(host + USERS + "/" + userId).build();
		
		try {
			Response response = client.getNewJsonPlaceHolderClient().newCall(request).execute();
			
			if(!response.isSuccessful()) {
				throw new ResponseServiceException(response.code(), response.message());
			}
			
			String responseBody = response.body().string();
			user = new Gson().fromJson(responseBody, User.class);
		} catch (IOException e) {
			throw new JsonPlaceHolderServiceException("GET - userById");
		}

		return user;
	}

	@Override
	public List<Photo> getAllPhotos() {
		List<Photo> photos = new ArrayList<>();
		Request request = new Request.Builder().url(host + PHOTOS).build();
		
		try {
			Response response = client.getNewJsonPlaceHolderClient().newCall(request).execute();
			
			if(!response.isSuccessful()) {
				throw new ResponseServiceException(response.code(), response.message());
			}
			
			Type photoList = new TypeToken<ArrayList<Photo>>(){}.getType();
			String responseBody = response.body().string();
			photos = new Gson().fromJson(responseBody, photoList);
		} catch (IOException e) {
			throw new JsonPlaceHolderServiceException("GET - allPhotos");
		}

		return photos;
	}

	@Override
	public Photo getPhotoById(long photoId) {
		Photo photo = new Photo();
		Request request = new Request.Builder().url(host + PHOTOS + "/" + photoId).build();
		
		try {
			Response response = client.getNewJsonPlaceHolderClient().newCall(request).execute();
			
			if(!response.isSuccessful()) {
				throw new ResponseServiceException(response.code(), response.message());
			}
			
			String responseBody = response.body().string();
			photo = new Gson().fromJson(responseBody, Photo.class);
		} catch (IOException e) {
			throw new JsonPlaceHolderServiceException("GET - photoById");
		}

		return photo;
	}

	@Override
	public List<Album> getAllAlbums() {
		List<Album> albums = new ArrayList<>();
		Request request = new Request.Builder().url(host + ALBUMS).build();
		
		try {
			Response response = client.getNewJsonPlaceHolderClient().newCall(request).execute();
			
			if(!response.isSuccessful()) {
				throw new ResponseServiceException(response.code(), response.message());
			}
			
			Type userList = new TypeToken<ArrayList<Album>>(){}.getType();
			String responseBody = response.body().string();
			albums = new Gson().fromJson(responseBody, userList);
		} catch (IOException e) {
			throw new JsonPlaceHolderServiceException("GET - allAlbums");
		}

		return albums;
	}

	@Override
	public Album getAlbumById(long albumId) {
		Album album = new Album();
		Request request = new Request.Builder().url(host + ALBUMS + "/" + albumId).build();
		
		try {
			Response response = client.getNewJsonPlaceHolderClient().newCall(request).execute();
			
			if(!response.isSuccessful()) {
				throw new ResponseServiceException(response.code(), response.message());
			}
			
			String responseBody = response.body().string();
			album = new Gson().fromJson(responseBody, Album.class);
		} catch (IOException e) {
			throw new JsonPlaceHolderServiceException("GET - photoById");
		}

		return album;
	}

	@Override
	public List<Album> getAlbumsByUser(long userId) {
		List<Album> albums = new ArrayList<>();
		Request request = new Request.Builder().url(host + USERS + "/" + userId + ALBUMS).build();
		
		try {
			Response response = client.getNewJsonPlaceHolderClient().newCall(request).execute();
			
			if(!response.isSuccessful()) {
				throw new ResponseServiceException(response.code(), response.message());
			}
			
			Type userList = new TypeToken<ArrayList<Album>>(){}.getType();
			String responseBody = response.body().string();
			albums = new Gson().fromJson(responseBody, userList);
		} catch (IOException e) {
			throw new JsonPlaceHolderServiceException("GET - allAlbums");
		}

		return albums;
	}

}
