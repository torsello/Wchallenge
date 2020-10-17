package com.wolox.socialnetwork.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolox.socialnetwork.exception.ObjectNotFoundException;
import com.wolox.socialnetwork.model.Role;
import com.wolox.socialnetwork.model.User;
import com.wolox.socialnetwork.model.UserAlbum;
import com.wolox.socialnetwork.repositories.RoleRepository;
import com.wolox.socialnetwork.repositories.UserAlbumRepository;
import com.wolox.socialnetwork.service.SocialNetworkService;
import com.wolox.socialnetwork.service.UserAlbumService;
import com.wolox.socialnetwork.service.dto.UserAlbumDto;

@Service
public class UserAlbumServiceImpl implements UserAlbumService {

	@Autowired
	private UserAlbumRepository repository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private SocialNetworkService socialNetworkService;
	
	@Override
	public UserAlbum createUserAlbum(UserAlbumDto userAlbumDto) {
		UserAlbum userAlbum = new UserAlbum();
		long userId = userAlbumDto.getUserId();
		Role role = roleRepository.findByRoleId(userAlbumDto.getRoleId());
		User user = socialNetworkService.getUserById(userId);
		
		if(role == null || user == null) {
			throw new ObjectNotFoundException("role or user");
		}
		
		userAlbum.setRole(role);
		userAlbum.setUserId(userId);
		
		return repository.save(userAlbum);
	}

	@Override
	public List<UserAlbum> getAllUserAlbums() {
		return repository.findAll();
	}

	@Override
	public UserAlbum getUserAlbumById(long userAlbumId) {
		return repository.findByUserAlbumId(userAlbumId);
	}

}
