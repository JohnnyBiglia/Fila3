package it.its.testEmployeesDB.dto;

import java.util.List;
import java.util.Optional;

import javax.persistence.Column;

import it.its.testEmployeesDB.dao.EmployeesDao;
import lombok.Data;

@Data
public class EmployeesDto {


	private Optional<EmployeesDao> dipendentiDato;

	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surname;

}
