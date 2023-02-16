package com.sts.springprojecttest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringProjectTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringProjectTestApplication.class, args);
	}
}
