package it.its.testEmployeesDB.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.its.testEmployeesDB.dao.CitiesDao;
import it.its.testEmployeesDB.dto.BaseResponseDto;
import it.its.testEmployeesDB.dto.CitiesDto;
import it.its.testEmployeesDB.repository.CitiesRepository;
import it.its.testEmployeesDB.services.CitiesService;
import it.its.testEmployeesDB.services.CitiesServiceImpl;


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
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "api/Cities/add")
	public ResponseEntity<Object> createVehicle(@RequestBody CitiesDao newCity){
        return new ResponseEntity<Object>(CitiesService.createCity(newCity), HttpStatus.CREATED);
    }
}