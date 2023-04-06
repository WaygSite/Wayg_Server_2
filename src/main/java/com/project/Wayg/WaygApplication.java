package com.project.Wayg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class WaygApplication implements WebMvcConfigurer {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins("*").
				allowedHeaders("*") // 어떤 헤더들을 허용할 것인지
				.allowedMethods("*");
	}

	public static void main(String[] args) {
		SpringApplication.run(WaygApplication.class, args);
	}

}
