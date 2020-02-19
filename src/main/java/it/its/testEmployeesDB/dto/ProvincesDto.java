package it.its.testEmployeesDB.dto;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProvincesDto {
	
	@Id
	@Column(name = "Id")
	private String id;
	
	@Column(name = "Description")
	private String description;

}
