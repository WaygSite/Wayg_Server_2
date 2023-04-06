package com.project.Wayg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class WaygApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(WaygApplication.class, args);
	}

}
