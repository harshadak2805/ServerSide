package com.user.role;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"com.user"})
public class UserRollSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserRollSystemApplication.class, args);
	}

}
