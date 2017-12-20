package com.hbo.secretmanagement.secretmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class SecretmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecretmanagementApplication.class, args);
	}
}
