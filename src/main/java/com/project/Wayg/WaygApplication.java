package com.project.Wayg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class WaygApplication{

	public static void main(String[] args) {
		SpringApplication.run(WaygApplication.class, args);
	}

}
