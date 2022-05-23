package com.ssafy.cafe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.ssafy.cafe.model.dao.OrderDao;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@MapperScan(basePackages = {"com.ssafy.cafe.vue.repo","com.ssafy.cafe.model.dao"})
public class MobileThrowProjectApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
//		SpringApplication.run(MobileThrowProjectApplication.class, args);
		
		CustomBeanNameGenerator beanNameGenerator = new CustomBeanNameGenerator();
        beanNameGenerator.addBasePackages("com.ssafy.cafe");
 
        new SpringApplicationBuilder(MobileThrowProjectApplication.class)
                .beanNameGenerator(beanNameGenerator)
                .run(args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MobileThrowProjectApplication.class);
	}
	

	@Bean
	public Docket postsApi() {
		final ApiInfo apiInfo = new ApiInfoBuilder()
				.title("SSAFY Cafe Rest API")
				.description("<h3>SSAFY Cafe에서 제공되는 Rest api의 문서 제공</h3>")
				.contact(new Contact("SSAFY", "https://edu.ssafy.com", "ssafy@ssafy.com"))
				.license("MIT License")
				.version("1.0")
				.build();

		Docket docket = new Docket(DocumentationType.SWAGGER_2)
				.groupName("SSAFY Cafe")
				.apiInfo(apiInfo)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.ssafy.cafe.controller.rest"))
				.build();
		return docket;
	}

}
