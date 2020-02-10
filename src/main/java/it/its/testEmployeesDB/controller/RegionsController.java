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
import it.its.testEmployeesDB.dao.RegionsDao;
import it.its.testEmployeesDB.dto.BaseResponseDto;
import it.its.testEmployeesDB.dto.CitiesDto;
import it.its.testEmployeesDB.dto.RegionsDto;
import it.its.testEmployeesDB.services.RegionsService;

@RestController
@RequestMapping(value = "api/Regions")
public class RegionsController {

	private static final Logger logger = LoggerFactory.getLogger(RegionsController.class);

	@Autowired
	RegionsService regionsService;

	@GetMapping(produces = "application/json")
	public BaseResponseDto<List<RegionsDto>> fatchAll() {
		
		BaseResponseDto<List<RegionsDto>> response = new BaseResponseDto<>();
		
		logger.info("****** Otteniamo le promozioni *******");

		List<RegionsDao> regions = regionsService.SelTutti();
		
		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE_COME_LA_MAMMA_DI_GIUSEPPE");
		
		if(regions.isEmpty()) {
			response.setResponse(null);
			return response;
		}
		
		logger.info("Numero dei record: " + regions.size());
		
		RegionsDto dto = new RegionsDto();
		dto.setRegionsData(regions);
		
		response.setResponse(dto);
		
		return response;
	}
	
	@GetMapping(produces = "application/json", value="/fetchOnce/{idRegion}")
	public BaseResponseDto<RegionsDto> SelOnce(@PathVariable("idRegion") long idRegion){
		BaseResponseDto<RegionsDto> response = new BaseResponseDto<>();
		
		Optional<RegionsDao> regione = regionsService.SelOnce(idRegion);
		
		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE_COME_LA_MAMMA_DI_GIUSEPPE");
		
		RegionsDto dto = new RegionsDto();
		dto.setRegionDato(regione);
		
		
		response.setResponse(dto);
		
		return response;
	}
}
