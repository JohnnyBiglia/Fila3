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

import it.its.testEmployeesDB.dao.CitiesDao;
import it.its.testEmployeesDB.dao.ProvincesDao;
import it.its.testEmployeesDB.dto.BaseResponseDto;
import it.its.testEmployeesDB.dto.CitiesDto;
import it.its.testEmployeesDB.dto.ProvincesDto;
import it.its.testEmployeesDB.services.ProvincesService;

@RestController
@RequestMapping(value = "api/provinces")
public class ProvincesController {

	private static final Logger logger = LoggerFactory.getLogger(ProvincesController.class);

	@Autowired
	ProvincesService provincesService;

	@GetMapping(produces = "application/json")
	public BaseResponseDto<List<ProvincesDto>> fatchAll() {
		
		BaseResponseDto<List<ProvincesDto>> response = new BaseResponseDto<>();
		
		logger.info("****** Otteniamo le promozioni *******");

		List<ProvincesDao> provinces = provincesService.SelTutti();
		
		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE_COME_LA_MAMMA_DI_GIUSEPPE");
		
		if(provinces.isEmpty()) {
			response.setResponse(null);
			return response;
		}
		
		logger.info("Numero dei record: " + provinces.size());
		
		ProvincesDto dto = new ProvincesDto();
		dto.setProvincesData(provinces);
		
		response.setResponse(dto);
		
		return response;
	}
	
	@GetMapping(produces = "application/json", value="/fetchOnce/{idProvince}")
	public BaseResponseDto<ProvincesDto> SelOnce(@PathVariable("idProvince") int idProvince){
		BaseResponseDto<ProvincesDto> response = new BaseResponseDto<>();
		
		Optional<ProvincesDao> citta = provincesService.SelOnce(idProvince);
		
		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE_COME_LA_MAMMA_DI_GIUSEPPE");
		
		ProvincesDto dto = new ProvincesDto();
		dto.setProvincesDato(citta);
		
		
		response.setResponse(dto);
		
		return response;
	}
}
