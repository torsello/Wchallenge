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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Photo> getAllPhotos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Photo getPhotoById(long photoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Album> getAllAlbums() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Album getAlbumById(long albumId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Album> getAlbumsByUser(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
