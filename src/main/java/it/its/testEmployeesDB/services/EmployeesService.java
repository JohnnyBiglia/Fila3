package it.its.testEmployeesDB.services;

import java.util.List;

import it.its.testEmployeesDB.dao.EmployeesDao;

public interface EmployeesService {
	public List<EmployeesDao> SelTutti();

	public EmployeesDao update(EmployeesDao employeeDetails);

	public void create(EmployeesDao empl);
}
