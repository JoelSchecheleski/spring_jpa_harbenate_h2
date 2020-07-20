package com.uppertools.curso.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.uppertools.curso.entities.User;
import com.uppertools.curso.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Joel Schecheleski", "joel.jsp@gmail.com", "47996688829", "123456789");
		User u2 = new User(null, "Kátia Michele Jurk Avalos Schecheleski", "kvalos@gmail.com", "", "123456789");
		User u3 = new User(null, "Miguel Schecheleski", "miguel@gmail.com", "", "123456789");
		User u4 = new User(null, "Raquel Schecheleski", "raquel@gmail.com", "", "123456789");
		userRepository.saveAll(Arrays.asList(u1, u2, u3, u4));
	}

}
