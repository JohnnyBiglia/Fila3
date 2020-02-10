package it.its.testEmployeesDB.dto;

import java.util.List;

import javax.persistence.Column;

import it.its.testEmployeesDB.dao.EmployeesDao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class EmployeesDto {
	
	@Column(name = "ID")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surname;

	
}
