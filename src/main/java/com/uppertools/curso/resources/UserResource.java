package com.uppertools.curso.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uppertools.curso.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<User> findAll() {
		User u = new User(1L, "Joel Schecheleski", "joel.jsp@gmail.com", "47996688829", "06544560");
		return ResponseEntity.ok().body(u);
	}

}
