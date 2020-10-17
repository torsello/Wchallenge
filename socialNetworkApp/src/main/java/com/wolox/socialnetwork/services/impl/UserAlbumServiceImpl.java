package com.wolox.socialnetwork.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolox.socialnetwork.exceptions.ObjectNotFoundException;
import com.wolox.socialnetwork.models.Album;
import com.wolox.socialnetwork.models.Role;
import com.wolox.socialnetwork.models.User;
import com.wolox.socialnetwork.models.UserAlbum;
import com.wolox.socialnetwork.repositories.RoleRepository;
import com.wolox.socialnetwork.repositories.UserAlbumRepository;
import com.wolox.socialnetwork.services.SocialNetworkService;
import com.wolox.socialnetwork.services.UserAlbumService;
import com.wolox.socialnetwork.services.dto.UserAlbumDto;

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
		long albumId = userAlbumDto.getAlbumId();
		Role role = roleRepository.findByRoleId(userAlbumDto.getRoleId());
		User user = socialNetworkService.getUserById(userId);
		Album album = socialNetworkService.getAlbumById(albumId);
		
		if(role == null || user == null || album == null) {
			throw new ObjectNotFoundException("role, user or album");
		}
		
		userAlbum.setRole(role);
		userAlbum.setAlbumId(albumId);
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
