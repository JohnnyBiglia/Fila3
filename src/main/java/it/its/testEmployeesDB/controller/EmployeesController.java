package it.its.testEmployeesDB.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;

import it.its.testEmployeesDB.dao.EmployeesDao;
import it.its.testEmployeesDB.dto.BaseResponseDto;
import it.its.testEmployeesDB.dto.EmployeesDto;
import it.its.testEmployeesDB.services.EmployeesService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/employees")
public class EmployeesController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeesController.class);

	@Autowired
	EmployeesService dipendentiService;

	@GetMapping(produces = "application/json")
	public BaseResponseDto<List<EmployeesDto>> fatchAll() {
		
		BaseResponseDto<List<EmployeesDto>> response = new BaseResponseDto<>();
		
		logger.info("****** Otteniamo le promozioni *******");

		List<EmployeesDto> dipendenti = dipendentiService.SelTutti();
		
		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE_COME_LA_MAMMA_DI_GIUSEPPE");
		
		if(dipendenti.isEmpty()) {
			response.setResponse(null);
			return response;
		}
		
		logger.info("Numero dei record: " + dipendenti.size());
		
		//ArrayList<EmployeesDto> dto = new ArrayList<EmployeesDto>();
		//dto=dipendentiService.SelTutti();
		
		
		response.setResponse(dipendenti);
		
		return response;
	}
	@GetMapping(value = "/delete/{idEmployees}", produces = "application/json") // percorso per richiamare il delete
	public BaseResponseDto<EmployeesDao> deleteEmployeesById(@PathVariable("idEmployees") int idEmployees) {//dichiaro in un long, l'ID da eliminare
		BaseResponseDto<EmployeesDao> response = new BaseResponseDto<EmployeesDao>();
		logger.info("****** Cancella il dipendente con id " + idEmployees + "******");

		try {// se viene cancellato correttament mi esce un messaggio di Deleted
			dipendentiService.deleteEmployeesById(idEmployees);
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
