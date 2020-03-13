package it.its.testEmployeesDB.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import it.its.testEmployeesDB.dao.CountriesDao;
import it.its.testEmployeesDB.dao.ProvincesDao;
import it.its.testEmployeesDB.dao.UserDao;
import it.its.testEmployeesDB.dto.CitiesDto;
import it.its.testEmployeesDB.dto.CountriesDto;
import it.its.testEmployeesDB.dto.ProvincesDto;
import it.its.testEmployeesDB.dto.UserDto;
import it.its.testEmployeesDB.repository.ProvincesRepository;
import it.its.testEmployeesDB.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDao update(UserDao user) {
		return userRepository.save(user);
	}

	@Override
	public void create(UserDao user) {
		userRepository.saveAndFlush(user);
	}

	@Override
	public Optional<UserDao> SelOnce(int id) {
		return userRepository.findById(id);
	}

	@Override
	public void deleteUserById(int id) {
		userRepository.deleteById(id);
	}

	@Override
	public List<UserDto> SelTutti() {
		List<UserDao> dao = userRepository.findAll();
		ArrayList<UserDto> dto = new ArrayList<UserDto>();
		for (UserDao d : dao) {
			UserDto temp = new UserDto();
			temp.setId(d.getId());
			temp.setNome((d.getNome()));
			temp.setRuolo(d.getRuolo());

			dto.add(temp);

		}
		return dto;
	}

	@Override
	public HttpStatus skyscanner() {
		
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String>request=new HttpEntity<String>("hello",headers);
		
		RestTemplate restTemplate=new RestTemplate();
		
		ResponseEntity<String> responseEntity=restTemplate.exchange("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/pricing/v1.0", HttpMethod.POST,request,String.class);
		responseEntity.getStatusCode();    
		
		if(responseEntity.getStatusCode().equals(HttpStatus.OK)) {
			responseEntity.getBody();
		}
		
		else {
			return HttpStatus.BAD_REQUEST;
		}
		return null;
		
		
		
	}
}
