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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.its.testEmployeesDB.dao.EmployeesDao;
import it.its.testEmployeesDB.dto.BaseResponseDto;
import it.its.testEmployeesDB.dto.EmployeesDto;
import it.its.testEmployeesDB.services.EmployeesService;

@RestController
@RequestMapping(value = "api/employees")
public class EmployeesController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeesController.class);

	@Autowired
	EmployeesService employeesService;

	@GetMapping(value = "/delete/{idEmployees}", produces = "application/json") // percorso per richiamare il delete
	public BaseResponseDto<String> deleteEmployeesById(@PathVariable("idEmployees") long idEmployees) {//dichiaro in un long, l'ID da eliminare
		BaseResponseDto<String> response = new BaseResponseDto<String>();
		logger.info("****** Cancella il dipendente con id " + idEmployees + "******");

		try {// se viene cancellato correttament mi esce un messaggio di Deleted
			employeesService.deleteEmployeesById(idEmployees);
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
	
	
	@GetMapping(value = "/fetchOnce/{idEmployees}", produces = "application/json") // percorso per richiamare il delete
	public BaseResponseDto<EmployeesDao> selOnce(@PathVariable("idEmployees") long idEmployees) {//dichiaro in un long, l'ID da eliminare
		BaseResponseDto<EmployeesDao> response = new BaseResponseDto<>();
		
		Optional<EmployeesDao> employees = employeesService.selOnce(idEmployees);
		
		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("Servizio_elaborato_correttamente");
		
		EmployeesDto dto = new EmployeesDto();
		dto.setEmployeesDato(employees);
		
		response.setResponse(dto);

		return response;// ritorno la risposta

	}
	
	

	@GetMapping(produces = "application/json")
	public BaseResponseDto<List<EmployeesDto>> fetchAll() {

		BaseResponseDto<List<EmployeesDto>> response = new BaseResponseDto<List<EmployeesDto>>();
		logger.info("****** Otteniamo tutte le promozioni *******");

		List<EmployeesDao> employees = employeesService.SelTutti();

		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("CORRETTO");

		if (employees.isEmpty()) {
			response.setResponse(null);
			return response;
		}

		logger.info("Numero dei record: " + employees.size());

		EmployeesDto dto = new EmployeesDto();
		dto.setEmployeesData(employees);

		response.setResponse(dto);
		return response;

	}

}
