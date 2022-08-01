package com.snkrphile.service;

import com.snkrphile.service.domain.Role;
import com.snkrphile.service.domain.User;
import com.snkrphile.service.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
@SpringBootApplication
public class ServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));

			userService.saveUser(new User(null, "Xavier", "Faulkner", "xavybaby02@gmail.com", 19, 28262, "x-man", "2002", new ArrayList<>(), new ArrayList<>()));
			userService.saveUser(new User(null, "Joe", "Shmoe", "joe@gmail.com", 45, 20705, "joe", "2002", new ArrayList<>(), new ArrayList<>()));

			userService.addRoleToUser("x-man", "ROLE_USER");
			userService.addRoleToUser("x-man", "ROLE_ADMIN");
			userService.addRoleToUser("joe", "ROLE_USER");
		};
	}

}
