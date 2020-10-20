package com.wolox.socialnetwork.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wolox.socialnetwork.dto.PatchUserAlbumDto;
import com.wolox.socialnetwork.dto.UserAlbumDto;
import com.wolox.socialnetwork.exceptions.ObjectNotFoundException;
import com.wolox.socialnetwork.models.Album;
import com.wolox.socialnetwork.models.Role;
import com.wolox.socialnetwork.models.User;
import com.wolox.socialnetwork.models.UserAlbum;
import com.wolox.socialnetwork.repositories.RoleRepository;
import com.wolox.socialnetwork.repositories.UserAlbumRepository;
import com.wolox.socialnetwork.services.SocialNetworkService;
import com.wolox.socialnetwork.services.UserAlbumService;

@Service
@Transactional(readOnly = true)
public class UserAlbumServiceImpl implements UserAlbumService {

	private final Logger logger = LoggerFactory.getLogger(getClass().getName());

	@Autowired
	private UserAlbumRepository repository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private SocialNetworkService socialNetworkService;

	@Override
	@Transactional
	public UserAlbum createUserAlbum(UserAlbumDto userAlbumDto) {
		logger.info("Creating new UserAlbum");
		
		UserAlbum userAlbum = new UserAlbum();
		long userId = userAlbumDto.getUserId();
		long albumId = userAlbumDto.getAlbumId();
		Role role = roleRepository.findByRoleId(userAlbumDto.getRoleId());
		User user = socialNetworkService.getUserById(userId);
		Album album = socialNetworkService.getAlbumById(albumId);

		if (role == null || user == null || album == null) {
			throw new ObjectNotFoundException("role");
		}

		userAlbum.setRole(role);
		userAlbum.setAlbumId(albumId);
		userAlbum.setUserId(userId);

		return repository.save(userAlbum);
	}

	@Override
	public List<UserAlbum> getAllUserAlbums() {
		logger.info("Getting all usersAlbum from db");

		return repository.findAll();
	}

	@Override
	public UserAlbum getUserAlbumById(long userAlbumId) {
		logger.info("Getting usersAlbum by id from db");

		return repository.findByUserAlbumId(userAlbumId);
	}

	@Override
	public List<UserAlbum> patchUserRoleByAlbumId(long albumId, PatchUserAlbumDto patchUserAlbumDto) {
		logger.info("Patching all userAlbum - Role by Album from db");
		
		List<UserAlbum> usersAlbums = repository.findAllByAlbumId(albumId);
		Role role = roleRepository.findByRoleId(patchUserAlbumDto.getRoleId());

		if (role == null) {
			throw new ObjectNotFoundException("role");
		}

		usersAlbums.stream().forEach(x -> {
			x.setRole(role);
			repository.save(x);
		});

		return usersAlbums;
	}

	@Override
	public List<User> getUsersByAlbumAndRole(long albumId, long roleId) {
		logger.info("Getting all users by Album and role");

		Role role = roleRepository.findByRoleId(roleId);
		List<User> users = new ArrayList<>();

		if (role == null) {
			throw new ObjectNotFoundException("role");
		}

		List<Long> usersId = repository.findAllUsersIdByAlbumAndRole(albumId, role);

		usersId.stream().forEach(x -> 
			users.add(socialNetworkService.getUserById(x))
		);

		return users;
	}

}
