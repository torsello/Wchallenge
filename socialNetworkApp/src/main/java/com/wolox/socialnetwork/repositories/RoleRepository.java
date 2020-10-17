package com.wolox.socialnetwork.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wolox.socialnetwork.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	public Role findByRoleId(long roleId);

}
