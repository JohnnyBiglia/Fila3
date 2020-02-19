package it.its.testEmployeesDB.services;

import java.util.List;
import java.util.Optional;

import it.its.testEmployeesDB.dao.EmployeesDao;
import it.its.testEmployeesDB.dto.EmployeesDto;

public interface EmployeesService {
<<<<<<< HEAD
	public List<EmployeesDao> SelTutti();

	public EmployeesDao update(EmployeesDao employeeDetails);
	public void deleteEmployeesById(long id);
	public void create(EmployeesDao empl);
	public Optional<EmployeesDao> SelOnce(int idEmployees);
=======
	public List<EmployeesDto> SelTutti();
	public void deleteEmployeesById(int id);
>>>>>>> refs/remotes/origin/updated_dao-dto
}
