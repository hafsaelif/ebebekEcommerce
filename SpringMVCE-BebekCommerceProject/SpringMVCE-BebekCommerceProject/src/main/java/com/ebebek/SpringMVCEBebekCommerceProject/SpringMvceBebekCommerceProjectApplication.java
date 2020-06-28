package com.ebebek.SpringMVCEBebekCommerceProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.*")
public class SpringMvceBebekCommerceProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvceBebekCommerceProjectApplication.class, args);
	}

}
