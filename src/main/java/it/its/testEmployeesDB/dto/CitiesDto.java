package it.its.testEmployeesDB.dto;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CitiesDto {
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "description")
	private String description;

}


