package it.its.testEmployeesDB.dto;

import java.util.List;
import java.util.Optional;

import it.its.testEmployeesDB.dao.EmployeesDao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeesDto {
	private List<EmployeesDao> dipendentiData;
	private Optional<EmployeesDao> dipendentiDato;

	


		
	
}
