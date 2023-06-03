package com.project.Wayg;

import com.project.Wayg.info.image.ImageParser;
import com.project.Wayg.info.repository.WaygRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class WaygApplication{
//	@Autowired
//	private ResourceLoader resourceLoader;
//
//	@Autowired
//	private WaygRepository waygRepository;

	public static void main(String[] args) {
		SpringApplication.run(WaygApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(ApplicationContext context) {
//		return args -> {
//			ImageParser imageParser = new ImageParser(resourceLoader, waygRepository);
//			imageParser.parseImageFileNamesAndSaveUrl();
//		};
//	}

}
