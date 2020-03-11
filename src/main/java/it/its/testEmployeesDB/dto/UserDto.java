package it.its.testEmployeesDB.dto;

import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Id;

import it.its.testEmployeesDB.dao.CitiesDao;
import it.its.testEmployeesDB.dao.UserDao;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserDto {

	private List<UserDao> userData;
	private Optional<UserDao> userDato;
	
	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String nome;

	@Column(name = "ruolo")
	private String ruolo;

	

}
