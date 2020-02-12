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
<<<<<<< HEAD
	private List<EmployeesDao> dipendentiData;
	private Optional<EmployeesDao> dipendentiDato;

	


		
	
=======

	private List<EmployeesDao> employeesData;

	private Optional<EmployeesDao> employeesDato;
>>>>>>> refs/remotes/origin/test
}
