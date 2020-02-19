package it.its.testEmployeesDB.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;

import it.its.testEmployeesDB.dao.RegionsDao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class RegionsDto {
	@Id
	@Column(name = "Id")
	private String id;
	
	@Column(name = "Description")
	private String description;

}
