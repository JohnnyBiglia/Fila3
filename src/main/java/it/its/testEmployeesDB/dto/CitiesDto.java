package it.its.testEmployeesDB.dto;

import java.util.List;
import java.util.Optional;

import it.its.testEmployeesDB.dao.CitiesDao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CitiesDto {
	private List<CitiesDao> cittaData;
	private Optional<CitiesDao> cittaDato;

}


