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

	@GetMapping(value = "/delete/{isoCountries}", produces = "application/json") // percorso per richiamare il delete
	public BaseResponseDto<String> deleteCountriesById(@PathVariable("isoCountries") String isoCountries) {//dichiaro in un long, l'ID da eliminare
		BaseResponseDto<String> response = new BaseResponseDto<String>();
		logger.info("****** Cancella la countries con id " + isoCountries + "******");

		try {// se viene cancellato correttament mi esce un messaggio di Deleted
			countriesService.deleteCountriesById(isoCountries);
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
	public BaseResponseDto<List<CountriesDto>> fetchAll() {

		BaseResponseDto<List<CountriesDto>> response = new BaseResponseDto<List<CountriesDto>>();
		logger.info("****** Otteniamo tutte le promozioni *******");

		List<CountriesDao> countries = countriesService.SelTutti();

		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("CORRETTO");

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

}
