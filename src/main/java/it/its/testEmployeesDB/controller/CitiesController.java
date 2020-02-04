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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.its.testEmployeesDB.dao.CitiesDao;
import it.its.testEmployeesDB.dto.BaseResponseDto;
import it.its.testEmployeesDB.dto.CitiesDto;
import it.its.testEmployeesDB.services.CitiesService;

@RestController
@RequestMapping(value = "api/Cities")
public class CitiesController {
	private static final Logger logger = LoggerFactory.getLogger(CitiesController.class);

	@Autowired
	CitiesService cittaService;

	@GetMapping(produces = "application/json")
	public BaseResponseDto<List<CitiesDto>> fatchAll() {

		BaseResponseDto<List<CitiesDto>> response = new BaseResponseDto<>();

		logger.info("****** Otteniamo le promozioni *******");

		List<CitiesDao> citta = cittaService.SelTutti();

		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE_COME_LA_MAMMA_DI_GIUSEPPE");

		if (citta.isEmpty()) {
			response.setResponse(null);
			return response;
		}

		logger.info("Numero dei record: " + citta.size());

		CitiesDto dto = new CitiesDto();
		dto.setCittaData(citta);

		response.setResponse(dto);

		return response;
	}

	@PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
	public BaseResponseDto<CitiesDao> update(@RequestBody String cityDetails)
			throws JsonMappingException, JsonProcessingException {
		BaseResponseDto<CitiesDao> response = new BaseResponseDto<>();

		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());

		ObjectMapper mapper = new ObjectMapper();
		CitiesDao city = mapper.readValue(cityDetails, CitiesDao.class);

		if (city.getId() != 0) {
			CitiesDao status = cittaService.update(city);
			response.setResponse(status);
			response.setMessage("UPDATE_ELABORATO_CORRETTAMENTE");
		} else {
			response.setMessage("ID_NON_INSERITO");
		}
		return response;

	}
}
