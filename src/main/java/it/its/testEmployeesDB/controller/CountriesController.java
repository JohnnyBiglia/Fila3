package it.its.testEmployeesDB.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.its.testEmployeesDB.dao.CountriesDao;
import it.its.testEmployeesDB.dto.BaseResponseDto;
import it.its.testEmployeesDB.dto.CountriesDto;
import it.its.testEmployeesDB.services.CountriesService;

@RestController
@RequestMapping(value = "api/countries")
public class CountriesController {

	private static final Logger logger = LoggerFactory.getLogger(CountriesController.class);

	@Autowired
	CountriesService countriesService;

	@GetMapping(produces = "application/json")
	public BaseResponseDto<List<CountriesDto>> fatchAll() {

		BaseResponseDto<List<CountriesDto>> response = new BaseResponseDto<>();

		logger.info("****** Otteniamo le promozioni *******");

		List<CountriesDao> countries = countriesService.SelTutti();

		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE_COME_LA_MAMMA_DI_GIUSEPPE");

		if (countries.isEmpty()) {
			response.setResponse(null);
			return response;
		}

		logger.info("Numero dei record: " + countries.size());

		CountriesDto dto = new CountriesDto();
		dto.setCountriesData(countries);

		response.setResponse(dto);

		return response;
	}

	@PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
	public BaseResponseDto<CountriesDao> update(@RequestBody String countriesDetails)
			throws JsonMappingException, JsonProcessingException {
		BaseResponseDto<CountriesDao> response = new BaseResponseDto<>();

		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());

		ObjectMapper mapper = new ObjectMapper();
		CountriesDao country = mapper.readValue(countriesDetails, CountriesDao.class);

		if (country.getIso() != 0) {
			CountriesDao status = countriesService.update(country);
			response.setResponse(status);
			response.setMessage("UPDATE_ELABORATO_CORRETTAMENTE");
		} else {
			response.setMessage("ID_NON_INSERITO");
		}
		return response;

	}
	
	@PostMapping("/add")
	public BaseResponseDto<List<CountriesDto>> createCity(@RequestBody CountriesDao country) {
		BaseResponseDto<List<CountriesDto>> response = new BaseResponseDto<>();

		logger.info("****** CREATE *******");

		countriesService.create(country);

		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE_COME_LA_MAMMA_DI_GIUSEPPE");

		return response;

	}
}
