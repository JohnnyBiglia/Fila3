package it.its.testEmployeesDB;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FilterCorsConfig implements WebMvcConfigurer {
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {

				registry.addMapping("/**").allowedOrigins("http://localhost:4200")
						.allowedMethods("PUT", "DELETE", "GET", "POST", "PATCH").allowedHeaders("*")
						.exposedHeaders("header1", "header2").allowCredentials(false).maxAge(4200);
			}
		};
	}
}
