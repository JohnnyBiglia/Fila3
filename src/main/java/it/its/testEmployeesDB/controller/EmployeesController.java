package it.its.testEmployeesDB.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value = "api/Employees")
public class EmployeesController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeesController.class);

	@Autowired
	EmployeesService dipendentiService;
	
	@GetMapping(produces = "application/json", value="/fetchOnce/{idEmployees}")
	public BaseResponseDto<EmployeesDto> SelOnce(@PathVariable("idEmployees") long idEmployees){
		BaseResponseDto<EmployeesDto> response = new BaseResponseDto<>();
		
		Optional<EmployeesDao> dipendenti = dipendentiService.SelOnce(idEmployees);
		
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

		List<EmployeesDao> dipendenti = dipendentiService.SelTutti();
		
		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE_COME_LA_MAMMA_DI_GIUSEPPE");
		
		if(dipendenti.isEmpty()) {
			response.setResponse(null);
			return response;
		}
		
		logger.info("Numero dei record: " + dipendenti.size());
		
		EmployeesDto dto = new EmployeesDto();
		dto.setDipendentiData(dipendenti);
		
		response.setResponse(dto);
		
		return response;
	}
}
