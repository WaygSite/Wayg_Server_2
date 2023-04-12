package com.project.Wayg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
        @Bean
        public Docket api(){
            return new Docket(DocumentationType.OAS_30)
                    .apiInfo(apiInfo())
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("com.project.Wayg"))
                    .paths(PathSelectors.any())
                    .build();

        }

        private ApiInfo apiInfo() {
            return new ApiInfoBuilder()
                    .title("Wayg API")
                    .description("영혼을 갈아넣은 프로젝트")
                    .version("1.0.0")
                    .build();
        }
    }
