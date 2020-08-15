package com.vemula.fun.tools.ChatAppSecurity;

import com.vemula.fun.tools.ChatAppSecurity.JpaRepository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class ChatAppSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatAppSecurityApplication.class, args);
	}

}
