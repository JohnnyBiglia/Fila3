package it.its.testEmployeesDB.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping(value = "api/cities")
public class CitiesController {
	private static final Logger logger = LoggerFactory.getLogger(CitiesController.class);

	@Autowired
	private CitiesService cittaService;

	@GetMapping(produces = "application/json")
	public BaseResponseDto<List<CitiesDto>> fatchAll() {

		BaseResponseDto<List<CitiesDto>> response = new BaseResponseDto<>();

		logger.info("****** Otteniamo le promozioni *******");

		List<CitiesDto> citta = cittaService.SelTutti();

		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE_COME_LA_MAMMA_DI_GIUSEPPE");

		if (citta.isEmpty()) {
			response.setResponse(null);
			return response;
		}

		logger.info("Numero dei record: " + citta.size());

		response.setResponse(citta);

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

	@PostMapping("/add")
	public BaseResponseDto<List<CitiesDto>> createCity(@RequestBody CitiesDao city) {
		BaseResponseDto<List<CitiesDto>> response = new BaseResponseDto<>();

		logger.info("****** CREATE *******");

		cittaService.create(city);

		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE_COME_LA_MAMMA_DI_GIUSEPPE");

		return response;

	}

	@GetMapping(produces = "application/json", value = "/fetchOnce/{idCity}")
	public BaseResponseDto<CitiesDto> SelOnce(@PathVariable("idCity") int idCity) {
		BaseResponseDto<CitiesDto> response = new BaseResponseDto<>();

		Optional<CitiesDao> citta = cittaService.SelOnce(idCity);

		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE_COME_LA_MAMMA_DI_GIUSEPPE");

		CitiesDto dto = new CitiesDto();
		dto.setCittaDato(citta);

		response.setResponse(dto);

		return response;
	}

	@GetMapping(value = "/delete/{idCities}", produces = "application/json") // percorso per richiamare il delete
	public BaseResponseDto<String> deleteCitiesById(@PathVariable("idCities") int idCities) {// dichiaro in un long,
																								// l'ID da eliminare
		BaseResponseDto<String> response = new BaseResponseDto<String>();
		logger.info("****** Cancella la cities con id " + idCities + "******");

		try {// se viene cancellato correttament mi esce un messaggio di Deleted
			cittaService.deleteCitiesById(idCities);
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
}
