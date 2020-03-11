package it.its.testEmployeesDB.dto;

import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Id;

import it.its.testEmployeesDB.dao.CitiesDao;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CitiesDto {

	private List<CitiesDao> cittaData;
	private Optional<CitiesDao> cittaDato;
	
	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "description")
	private String description;

}
