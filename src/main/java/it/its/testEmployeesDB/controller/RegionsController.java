package it.its.testEmployeesDB.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.its.testEmployeesDB.dao.RegionsDao;
import it.its.testEmployeesDB.dto.BaseResponseDto;
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

	@PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
	public BaseResponseDto<RegionsDao> update(@RequestBody String regionDetails)
			throws JsonMappingException, JsonProcessingException {
		BaseResponseDto<RegionsDao> response = new BaseResponseDto<>();

		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());

		ObjectMapper mapper = new ObjectMapper();
		RegionsDao region = mapper.readValue(regionDetails, RegionsDao.class);

		if (region.getId() != 0) {
			RegionsDao status = regionsService.update(region);
			response.setResponse(status);
			response.setMessage("UPDATE_ELABORATO_CORRETTAMENTE");
		} else {
			response.setMessage("ID_NON_INSERITO");
		}
		return response;

	}
}
