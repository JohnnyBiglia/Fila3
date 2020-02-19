package it.its.testEmployeesDB.dto;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CountriesDto {
	@Id
	@Column(name = "iso")
	private String iso;
	
	@Column(name = "description")
	private String description;

}
