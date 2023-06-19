package com.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUsername(String username);

}

