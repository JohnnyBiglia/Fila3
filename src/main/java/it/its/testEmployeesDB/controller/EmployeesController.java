package it.its.testEmployeesDB.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

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

	@GetMapping(produces = "application/json", value = "/fetchOnce/employee/{idEmployees}")
	public BaseResponseDto<EmployeesDto> SelOnce(@PathVariable("idEmployees") int idEmployees) {
		BaseResponseDto<EmployeesDto> response = new BaseResponseDto<>();

		Optional<EmployeesDao> employees = employeesService.SelOnce(idEmployees);

		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE_COME_LA_MAMMA_DI_GIUSEPPE");

		EmployeesDto dto = new EmployeesDto();
		dto.setDipendentiDato(employees);

		response.setResponse(dto);

		return response;
	}

	@GetMapping(produces = "application/json")
	public BaseResponseDto<List<EmployeesDto>> fetchAll() {

		BaseResponseDto<List<EmployeesDto>> response = new BaseResponseDto<>();

		logger.info("****** Otteniamo le promozioni *******");

		List<EmployeesDto> dipendenti = employeesService.SelTutti();

		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE_COME_LA_MAMMA_DI_GIUSEPPE");

		if (dipendenti.isEmpty()) {
			response.setResponse(null);
			return response;
		}

		logger.info("Numero dei record: " + dipendenti.size());

		response.setResponse(dipendenti);

		return response;
	}
	@GetMapping(value="/filter/{param}",produces = "application/json")
	public BaseResponseDto<List<EmployeesDto>> filter(@PathVariable("param") String param) {

		BaseResponseDto<List<EmployeesDto>> response = new BaseResponseDto<>();

		logger.info("****** Otteniamo le promozioni *******");

		List<EmployeesDto> dipendenti = employeesService.filterEmployees(param);

		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE_COME_LA_MAMMA_DI_GIUSEPPE");

		if (dipendenti.isEmpty()) {
			response.setResponse(null);
			return response;
		}

		logger.info("Numero dei record: " + dipendenti.size());

		response.setResponse(dipendenti);
		
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAA:  "+response+" "+param);

		return response;
	}

	@PatchMapping(value = "/update", produces = "application/json")
	public BaseResponseDto<EmployeesDao> update(@RequestBody EmployeesDao employee)
			throws JsonMappingException, JsonProcessingException {
		BaseResponseDto<EmployeesDao> response = new BaseResponseDto<>();

		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());

		if (employee.getId() != 0) {
			EmployeesDao status = employeesService.update(employee);
			response.setResponse(status);
			response.setMessage("UPDATE_ELABORATO_CORRETTAMENTE");
		} else {
			response.setMessage("ID_NON_INSERITO");
		}
		return response;
	}

	@PostMapping("/add")
	public BaseResponseDto<List<EmployeesDto>> createCity(@RequestBody EmployeesDao empl) {
		BaseResponseDto<List<EmployeesDto>> response = new BaseResponseDto<>();

		logger.info("****** CREATE *******");

		employeesService.create(empl);

		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE_COME_LA_MAMMA_DI_GIUSEPPE");

		return response;

	}

	@DeleteMapping(value = "/delete/{idEmployees}", produces = "application/json") // percorso per richiamare il delete
	public BaseResponseDto<String> deleteEmployeesById(@PathVariable("idEmployees") int idEmployees) {// dichiaro in un
																										// long, l'ID da
																										// eliminare
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

}
