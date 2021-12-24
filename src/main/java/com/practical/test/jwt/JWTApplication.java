package com.practical.test.jwt;

import com.practical.test.jwt.entity.User;
import com.practical.test.jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class JWTApplication {

	@Autowired
	UserRepository repository;

	@PostConstruct
	public void initUsers() {
		List<User> users = Stream.of(
				new User(101, "admin", "admin"),
				new User(102, "user1", "pwd1"),
				new User(103, "user2", "pwd2"),
				new User(104, "user3", "pwd3")
		).collect(Collectors.toList());
		repository.saveAll(users);
	}

	public static void main(String[] args) {
		SpringApplication.run(JWTApplication.class, args);
	}

}
