package com.uppertools.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uppertools.curso.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
