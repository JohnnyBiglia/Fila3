package it.its.testEmployeesDB.services;

import java.util.List;

import it.its.testEmployeesDB.dao.EmployeesDao;

public interface EmployeesService {
	public List<EmployeesDao> SelTutti();

	public void create(EmployeesDao empl);
}
