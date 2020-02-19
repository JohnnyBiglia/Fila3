package it.its.testEmployeesDB.dto;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CountriesDto {
	@Id
	@Column(name = "ISO")
	private String iso;
	
	@Column(name = "Description")
	private String description;

}
