package com.uppertools.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uppertools.curso.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	
	
}
