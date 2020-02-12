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

import it.its.testEmployeesDB.dao.ProvincesDao;
import it.its.testEmployeesDB.dto.BaseResponseDto;
import it.its.testEmployeesDB.dto.ProvincesDto;
import it.its.testEmployeesDB.services.ProvincesService;

@RestController
@RequestMapping(value = "api/provinces")
public class ProvincesController {

	private static final Logger logger = LoggerFactory.getLogger(ProvincesController.class);

	@Autowired
	ProvincesService provincesService;

	@GetMapping(value = "/delete/{idProvinces}", produces = "application/json") // percorso per richiamare il delete
	public BaseResponseDto<String> deleteProvincesById(@PathVariable("idProvinces") String idProvinces) {//dichiaro in un long, l'ID da eliminare
		BaseResponseDto<String> response = new BaseResponseDto<String>();
		logger.info("****** Cancella la provinces con id " + idProvinces + "******");

		try {// se viene cancellato correttament mi esce un messaggio di Deleted
			provincesService.deleteProvincesById(idProvinces);
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
	public BaseResponseDto<List<ProvincesDto>> fetchAll() {

		BaseResponseDto<List<ProvincesDto>> response = new BaseResponseDto<List<ProvincesDto>>();
		logger.info("****** Otteniamo tutte le promozioni *******");

		List<ProvincesDao> provinces = provincesService.SelTutti();

		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("CORRETTO");

		if (provinces.isEmpty()) {
			response.setResponse(null);
			return response;
		}

		logger.info("Numero dei record: " + provinces.size());

		ProvincesDto dto = new ProvincesDto();
		dto.setProvincesData(provinces);

		response.setResponse(dto);
		return response;

	}

}
