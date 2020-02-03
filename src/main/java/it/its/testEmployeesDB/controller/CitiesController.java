package it.its.testEmployeesDB.controller;

import java.net.URI;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import it.its.testEmployeesDB.dao.CitiesDao;
import it.its.testEmployeesDB.dto.BaseResponseDto;
import it.its.testEmployeesDB.dto.CitiesDto;
import it.its.testEmployeesDB.repository.CitiesRepository;
import it.its.testEmployeesDB.services.CitiesService;


@RestController
@RequestMapping(value = "api/Cities")
public class CitiesController {
	private static final Logger logger = LoggerFactory.getLogger(CitiesController.class);

	@Autowired
	private CitiesService cittaService;
	
	@Autowired
	private CitiesRepository citiesRepository;

	@GetMapping(produces = "application/json")
	public BaseResponseDto<List<CitiesDto>> fatchAll() {
		
		BaseResponseDto<List<CitiesDto>> response = new BaseResponseDto<>();
		
		logger.info("****** Otteniamo le promozioni *******");

		List<CitiesDao> citta = cittaService.SelTutti();
		
		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE_COME_LA_MAMMA_DI_GIUSEPPE");
		
		if(citta.isEmpty()) {
			response.setResponse(null);
			return response;
		}
		
		logger.info("Numero dei record: " + citta.size());
		
		CitiesDto dto = new CitiesDto();
		dto.setCittaData(citta);
		
		response.setResponse(dto);
		
		return response;
	}
	
	@PostMapping("/add")
	public ResponseEntity<Object> createCity(@RequestBody CitiesDao city) {
		CitiesDao savedCity = citiesRepository.saveAndFlush(city);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedCity.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
}








