package com.java.jquery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.java.jquery.repository") // Ensure correct package
public class SpringBootJQueryApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootJQueryApplication.class, args);
    }
}
