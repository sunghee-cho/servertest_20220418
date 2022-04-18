package edu.multi.boot1;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//현재파일 웹설정포함파일//<resource .... 
@Configuration
public class MyWebConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry
		.addResourceHandler("/upload/**")
		.addResourceLocations("file:///c:/upload/");
		registry
		.addResourceHandler("/naverimages/**")
		.addResourceLocations("file:///C:/Users/student/Desktop/ai_images/");		
		System.out.println("===MyWebConfig실행===");
	}
	
//http://localshoT;8080/upload/파일목록
	
//	http://localshoT;8080/naverimages
}
