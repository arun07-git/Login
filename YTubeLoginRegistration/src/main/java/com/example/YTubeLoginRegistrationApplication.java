package com.example;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;




@SpringBootApplication
@EnableJpaRepositories
@EnableSwagger2

public class YTubeLoginRegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(YTubeLoginRegistrationApplication.class, args);
	}
	
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors
						.basePackage("com.example"))
				.build();
}
}
