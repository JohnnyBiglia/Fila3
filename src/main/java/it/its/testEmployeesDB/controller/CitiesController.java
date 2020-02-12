package it.its.testEmployeesDB.controller;

import java.util.Date;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.its.testEmployeesDB.dao.CitiesDao;
import it.its.testEmployeesDB.dto.BaseResponseDto;
import it.its.testEmployeesDB.dto.CitiesDto;
import it.its.testEmployeesDB.services.CitiesService;

@RestController
@RequestMapping(value = "api/cities")
public class CitiesController {

	private static final Logger logger = LoggerFactory.getLogger(CitiesController.class);

	@Autowired
	CitiesService citiesService;

	@GetMapping(value = "/delete/{idCities}", produces = "application/json") // percorso per richiamare il delete
	public BaseResponseDto<String> deleteCitiesById(@PathVariable("idCities") String idCities) {//dichiaro in un long, l'ID da eliminare
		BaseResponseDto<String> response = new BaseResponseDto<String>();
		logger.info("****** Cancella la cities con id " + idCities + "******");

		try {// se viene cancellato correttament mi esce un messaggio di Deleted
			citiesService.deleteCitiesById(idCities);
			response.setResponse("Deleted");
		} catch (EmptyResultDataAccessException ex) {// altrimenti non e' successo nulla
			response.setResponse("Not found");
		}
		// setto la risposta assegnandole una nuova data, un nuovo valore ed un
		// messaggio finale
		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("Service_was_successful");

		return response;// ritorno la risposta

	}
	

	@GetMapping(produces = "application/json")
	public BaseResponseDto<List<CitiesDto>> fetchAll() {

		BaseResponseDto<List<CitiesDto>> response = new BaseResponseDto<List<CitiesDto>>();
		logger.info("****** Otteniamo tutte le promozioni *******");

		List<CitiesDao> cities = citiesService.SelTutti();

		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("CORRETTO");

		if (cities.isEmpty()) {
			response.setResponse(null);
			return response;
		}

		logger.info("Numero dei record: " + cities.size());

		CitiesDto dto = new CitiesDto();
		dto.setCitiesData(cities);

		response.setResponse(dto);
		return response;

	}

}
