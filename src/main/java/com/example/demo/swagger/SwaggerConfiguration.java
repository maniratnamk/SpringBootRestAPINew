package com.example.demo.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.filter.RegexPatternTypeFilter;

import io.swagger.models.Contact;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@EnableSwagger2
//@Configuration
public class SwaggerConfiguration {

	/*
	 * @Bean public Docket SpringRestApi() { return new
	 * Docket(DocumentationType.SWAGGER_2). select().
	 * apis(RequestHandlerSelectors.basePackage("com.example.swagger")).
	 * paths(PathSelectors.regex("/*")). build(). apiInfo(new
	 * ApiInfo("SpringBoot Rest API","RestApi Example developed by Maniratnam "
	 * ,"1.0","","Maniratnam","License No:123","Licensed by :Apache")); }
	 */
	
}
