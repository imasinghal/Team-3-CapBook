package com.cg.capbook.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages= {"com.cg.capbook"})
@EntityScan(basePackages= {"com.cg.capbook.beans"})
@EnableJpaRepositories(basePackages= {"com.cg.capbook.dao"})
@EnableWebMvc
public class CapBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapBookApplication.class, args);
	}
}
