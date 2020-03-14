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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.its.testEmployeesDB.dao.UserDao;
import it.its.testEmployeesDB.dto.BaseResponseDto;
import it.its.testEmployeesDB.dto.CountriesDto;
import it.its.testEmployeesDB.dto.EmployeesDto;
import it.its.testEmployeesDB.dto.UserDto;
import it.its.testEmployeesDB.services.UserService;
import sun.rmi.transport.proxy.HttpReceiveSocket;

@RestController
@RequestMapping(value = "api/user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@GetMapping(produces = "application/json")
	public BaseResponseDto<List<UserDto>> fetchAll() {

		BaseResponseDto<List<UserDto>> response = new BaseResponseDto<>();

		logger.info("****** Otteniamo le promozioni *******");

		List<UserDto> user = userService.SelTutti();

		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE_COME_LA_MAMMA_DI_GIUSEPPE");

		if (user.isEmpty()) {
			response.setResponse(null);
			return response;
		}

		logger.info("Numero dei record: " + user.size());

		response.setResponse(user);

		return response;
	}

	@PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
	public BaseResponseDto<UserDao> update(@RequestBody String userDetails)
			throws JsonMappingException, JsonProcessingException {
		BaseResponseDto<UserDao> response = new BaseResponseDto<>();

		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());

		ObjectMapper mapper = new ObjectMapper();
		UserDao user = mapper.readValue(userDetails, UserDao.class);

		if (user.getId() != 0) {
			UserDao status = userService.update(user);
			response.setResponse(status);
			response.setMessage("UPDATE_ELABORATO_CORRETTAMENTE");
		} else {
			response.setMessage("ID_NON_INSERITO");
		}
		return response;

	}

	@PostMapping("/add")
	public BaseResponseDto<List<UserDto>> createUser(@RequestBody UserDao user) {
		BaseResponseDto<List<UserDto>> response = new BaseResponseDto<>();

		logger.info("****** CREATE *******");

		userService.create(user);

		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE_COME_LA_MAMMA_DI_GIUSEPPE");

		return response;

	}

	@GetMapping(produces = "application/json", value = "/fetchOnce/{idUser}")
	public BaseResponseDto<UserDto> SelOnce(@PathVariable("idUser") int idUser) {
		BaseResponseDto<UserDto> response = new BaseResponseDto<>();

		Optional<UserDao> user = userService.SelOnce(idUser);

		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE_COME_LA_MAMMA_DI_GIUSEPPE");

		UserDto dto = new UserDto();
		dto.setUserDato(user);

		response.setResponse(dto);

		return response;
	}

	@GetMapping(value = "/delete/{idUser}", produces = "application/json") // percorso per richiamare il delete
	public BaseResponseDto<String> deleteUserById(@PathVariable("idUser") int idUser) {// dichiaro in un long,
																								// l'ID da eliminare
		BaseResponseDto<String> response = new BaseResponseDto<String>();
		logger.info("****** Cancella user con id " + idUser + "******");

		try {// se viene cancellato correttament mi esce un messaggio di Deleted
			userService.deleteUserById(idUser);
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
	
	@GetMapping(value="/filter/{param}",produces = "application/json")
	public BaseResponseDto<List<EmployeesDto>> filter(@PathVariable("param") String param) {

		BaseResponseDto<List<EmployeesDto>> response = new BaseResponseDto<>();

		logger.info("****** Otteniamo le promozioni *******");

		List<UserDto> dipendenti = userService.filterUsers(param);

		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE_COME_LA_MAMMA_DI_GIUSEPPE");

		if (dipendenti.isEmpty()) {
			response.setResponse(null);
			return response;
		}

		response.setResponse(dipendenti);

		return response;
	}
	

}
