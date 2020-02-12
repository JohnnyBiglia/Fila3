package it.its.testEmployeesDB.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.its.testEmployeesDB.dao.EmployeesDao;
import it.its.testEmployeesDB.dto.BaseResponseDto;
import it.its.testEmployeesDB.dto.EmployeesDto;
import it.its.testEmployeesDB.services.EmployeesService;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "api/employees")
public class EmployeesController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeesController.class);

	@Autowired
	EmployeesService employeesService;
	
	@GetMapping(produces = "application/json", value="/fetchOnce/employee/{idEmployees}")
	public BaseResponseDto<EmployeesDto> SelOnce(@PathVariable("idEmployees") int idEmployees){
		BaseResponseDto<EmployeesDto> response = new BaseResponseDto<>();
		
		Optional<EmployeesDao> dipendenti = employeesService.SelOnce(idEmployees);
		
		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE_COME_LA_MAMMA_DI_GIUSEPPE");
		
		EmployeesDto dto = new EmployeesDto();
		dto.setDipendentiDato(dipendenti);
		
		
		response.setResponse(dto);
		
		return response;
	}
	

	@GetMapping(produces = "application/json")
	public BaseResponseDto<List<EmployeesDto>> fetchAll() {

		BaseResponseDto<List<EmployeesDto>> response = new BaseResponseDto<>();

		logger.info("****** Otteniamo le promozioni *******");

		List<EmployeesDao> dipendenti = employeesService.SelTutti();

		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE_COME_LA_MAMMA_DI_GIUSEPPE");

		if (dipendenti.isEmpty()) {
			response.setResponse(null);
			return response;
		}

		logger.info("Numero dei record: " + dipendenti.size());

		EmployeesDto dto = new EmployeesDto();
		dto.setDipendentiData(dipendenti);

		response.setResponse(dto);

		return response;
	}

	@PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
	public BaseResponseDto<EmployeesDao> update(@RequestBody String employeeDetails)
			throws JsonMappingException, JsonProcessingException {
		BaseResponseDto<EmployeesDao> response = new BaseResponseDto<>();

		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());

		ObjectMapper mapper = new ObjectMapper();
		EmployeesDao employee = mapper.readValue(employeeDetails, EmployeesDao.class);

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

}
