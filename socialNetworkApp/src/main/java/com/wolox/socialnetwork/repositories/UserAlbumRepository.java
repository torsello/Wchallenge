package com.wolox.socialnetwork.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wolox.socialnetwork.models.Role;
import com.wolox.socialnetwork.models.UserAlbum;

@Repository
public interface UserAlbumRepository extends JpaRepository<UserAlbum, Long> {

	public UserAlbum findByUserAlbumId(long userAlbumId);

	public List<UserAlbum> findAllByAlbumId(long albumId);

	@Query("SELECT u.userId from UserAlbum u where u.albumId = ?1 and u.role = ?2 ")
	public List<Long> findAllUsersIdByAlbumAndRole(long albumId, Role role);

}
