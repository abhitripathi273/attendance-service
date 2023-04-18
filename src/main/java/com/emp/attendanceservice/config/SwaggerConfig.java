package com.emp.attendanceservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
public class SwaggerConfig {
	 /**
    *
    * @return Docket
    */
   @Bean
   public Docket api() {
	   return new Docket(DocumentationType.SWAGGER_2)
		         .select()
		         .apis(RequestHandlerSelectors.basePackage("com.emp.attendanceservice.rest"))
		         .paths(PathSelectors.any())
		         .build();
   }
}
