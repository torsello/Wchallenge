package com.wolox.socialnetwork.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wolox.socialnetwork.model.UserAlbum;

@Repository
public interface UserAlbumRepository extends JpaRepository<UserAlbum, Long>{

	public UserAlbum findByUserAlbumId(long userAlbumId);
	

}
