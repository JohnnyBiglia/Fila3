package it.its.testEmployeesDB.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.its.testEmployeesDB.dao.CountriesDao;
import it.its.testEmployeesDB.dao.EmployeesDao;
import it.its.testEmployeesDB.dto.BaseResponseDto;
import it.its.testEmployeesDB.dto.CountriesDto;
import it.its.testEmployeesDB.dto.EmployeesDto;
import it.its.testEmployeesDB.services.CountriesService;

@RestController
@RequestMapping(value = "api/countries")
public class CountriesController {

	private static final Logger logger = LoggerFactory.getLogger(CountriesController.class);

	@Autowired
	CountriesService countriesService;

	@GetMapping(produces = "application/json")
	public BaseResponseDto<List<CountriesDto>> fetchAll() {
		
		BaseResponseDto<List<CountriesDto>> response = new BaseResponseDto<>();
		
		logger.info("****** Otteniamo le promozioni *******");

		List<CountriesDao> countries = countriesService.SelTutti();
		
		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE_COME_LA_MAMMA_DI_GIUSEPPE");
		
		if(countries.isEmpty()) {
			response.setResponse(null);
			return response;
		}
		
		logger.info("Numero dei record: " + countries.size());
		
		CountriesDto dto = new CountriesDto();
		dto.setCountriesData(countries);
		
		response.setResponse(dto);
		
		return response;
	}
	
	@GetMapping(produces = "application/json", value="/fetchOnce/{idCountry}")
	public BaseResponseDto<CountriesDto> SelOnce(@PathVariable("idCountry") String idCountry){
		BaseResponseDto<CountriesDto> response = new BaseResponseDto<>();
		
		Optional<CountriesDao> nazioni = countriesService.SelOnce(idCountry);
		
		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE_COME_LA_MAMMA_DI_GIUSEPPE");
		
		CountriesDto dto = new CountriesDto();
		dto.setCountriesDato(nazioni);
		
		
		response.setResponse(dto);
		
		return response;
	}
}
