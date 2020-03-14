package it.its.testEmployeesDB.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "api/restapi")
public class RestApiController {
	
	@RequestMapping(value="/nazioni")
	public String restNazioni() {
		
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String>request=new HttpEntity<String>("hello",headers);
		
		RestTemplate restTemplate=new RestTemplate();
		
		ResponseEntity<String> responseEntity=null;
		  
		
		try {
			responseEntity=restTemplate.exchange("https://restcountries.eu/rest/v2/all", HttpMethod.GET,request,String.class);
		} 
		
		catch (Exception e) {
			System.out.println("No connection");
			
		}
		return responseEntity.getBody();
		
		
		
	}
}
