package com.demo.springsecurity;

import com.demo.springsecurity.model.Role;
import com.demo.springsecurity.model.User;
import com.demo.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
public class SpringsecurityApplication {
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void init(){
		User user = new User(
				"Antariksh",
				"Meshram",
				"antariksh@webonise.com",
				passwordEncoder.encode("password"),
				Arrays.asList(
						new Role("ROLE_USER"),
						new Role("ROLE_ADMIN")));
		if (userRepository.findByEmail(user.getEmail()) == null) {
			userRepository.save(user);
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityApplication.class, args);
	}
}
