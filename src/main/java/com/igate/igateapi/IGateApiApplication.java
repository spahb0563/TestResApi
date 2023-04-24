package com.igate.igateapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
@SpringBootApplication
public class IGateApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(IGateApiApplication.class, args);
	}

}
