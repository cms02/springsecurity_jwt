package com.cms.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cms.jwt.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public User findByUsername(String username);

}
