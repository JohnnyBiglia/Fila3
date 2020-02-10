package it.its.testEmployeesDB;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

<<<<<<< HEAD
//info Cors https://developer.mozilla.org/it/docs/Web/HTTP/CORS

@Configuration
public class FilterCorsConfig implements WebMvcConfigurer {

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {

				registry.addMapping("/**").allowedOrigins("http://localhost:4200")
						.allowedMethods("PUT", "DELETE", "GET", "POST").allowedHeaders("*")
						.exposedHeaders("header1", "header2").allowCredentials(false).maxAge(3600);
=======
@Configuration
public class FilterCorsConfig implements WebMvcConfigurer{
	@Bean
	public WebMvcConfigurer corsConfigurer()
	{
		return new WebMvcConfigurer()
		{
			@Override
			public void addCorsMappings(CorsRegistry registry)
			{
				
				registry
					.addMapping("/**")
					.allowedOrigins("http://localhost:4200")
					.allowedMethods("PUT", "DELETE", "GET", "POST")
					.allowedHeaders("*")
					.exposedHeaders("header1", "header2")
					.allowCredentials(false)
					.maxAge(4200);
>>>>>>> refs/heads/post
			}
		};
	}

}
