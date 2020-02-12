package it.its.testEmployeesDB.services;

import java.util.List;
import java.util.Optional;

import it.its.testEmployeesDB.dao.EmployeesDao;

public interface EmployeesService {
	public List<EmployeesDao> SelTutti();

	public EmployeesDao update(EmployeesDao employeeDetails);
	public void deleteEmployeesById(long id);
	public void create(EmployeesDao empl);
	public Optional<EmployeesDao> SelOnce(int idEmployees);
}
