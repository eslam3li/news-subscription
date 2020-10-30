package com.news.subscription.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.news.subscription.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByName(String name);

	Boolean existsByName(String name);

	Boolean existsByEmail(String email);

}
