package it.its.testEmployeesDB.dto;

import java.util.List;
import java.util.Optional;

import it.its.testEmployeesDB.dao.CitiesDao;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CitiesDto {

	private List<CitiesDao> cittaData;
	private Optional<CitiesDao> cittaDato;

}
