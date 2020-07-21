package com.uppertools.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.uppertools.curso.entities.Category;
import com.uppertools.curso.entities.Order;
import com.uppertools.curso.entities.User;
import com.uppertools.curso.entities.enums.OrderStatus;
import com.uppertools.curso.repositories.CategoryRepository;
import com.uppertools.curso.repositories.OrderRepository;
import com.uppertools.curso.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository; 

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		User u1 = new User(null, "Joel Schecheleski", "joel.jsp@gmail.com", "47996688829", "123456789");
		User u2 = new User(null, "Kátia Michele Jurk Avalos Schecheleski", "kvalos@gmail.com", "", "123456789");
		User u3 = new User(null, "Miguel Schecheleski", "miguel@gmail.com", "", "123456789");
		User u4 = new User(null, "Raquel Schecheleski", "raquel@gmail.com", "", "123456789");
		userRepository.saveAll(Arrays.asList(u1, u2, u3, u4));

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u3);
		Order o4 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.PAID, u4);
		Order o5 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.SHIPPED, u1);
		Order o6 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.DELIVERED, u2);
		orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4, o5, o6));
		
	}

}
