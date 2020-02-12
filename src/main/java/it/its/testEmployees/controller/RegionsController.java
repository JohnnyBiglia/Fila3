package it.its.testEmployees.controller;

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

import it.its.testEmployees.dao.RegionsDao;
import it.its.testEmployees.dto.BaseResponseDto;
import it.its.testEmployees.dto.RegionsDto;
import it.its.testEmployees.services.RegionsService;

@RestController
@RequestMapping(value = "api/regions")
public class RegionsController {

	private static final Logger logger = LoggerFactory.getLogger(RegionsController.class);

	@Autowired
	RegionsService regionsService;

	@GetMapping(value = "/delete/{idRegions}", produces = "application/json") // percorso per richiamare il delete
	public BaseResponseDto<String> deleteRegionsById(@PathVariable("idRegions") String idRegions) {//dichiaro in un long, l'ID da eliminare
		BaseResponseDto<String> response = new BaseResponseDto<String>();
		logger.info("****** Cancella la regions con id " + idRegions + "******");

		try {// se viene cancellato correttament mi esce un messaggio di Deleted
			regionsService.deleteRegionsById(idRegions);
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
	public BaseResponseDto<List<RegionsDto>> fetchAll() {

		BaseResponseDto<List<RegionsDto>> response = new BaseResponseDto<List<RegionsDto>>();
		logger.info("****** Otteniamo tutte le promozioni *******");

		List<RegionsDao> regions = regionsService.SelTutti();

		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("CORRETTO");

		if (regions.isEmpty()) {
			response.setResponse(null);
			return response;
		}

		logger.info("Numero dei record: " + regions.size());

		RegionsDto dto = new RegionsDto();
		dto.setRegionsData(regions);

		response.setResponse(dto);
		return response;

	}

}