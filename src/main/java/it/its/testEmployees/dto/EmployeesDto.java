package it.its.testEmployees.dto;

import java.util.List;
import java.util.Optional;

import it.its.testEmployees.dao.EmployeesDao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeesDto {

	private List<EmployeesDao> employeesData;

	private Optional<EmployeesDao> employeesDato;
}
