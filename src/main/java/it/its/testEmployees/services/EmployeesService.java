package it.its.testEmployees.services;

import java.util.List;
import java.util.Optional;

import it.its.testEmployees.dao.EmployeesDao;

public interface EmployeesService {

	public List<EmployeesDao> SelTutti();
	public void deleteEmployeesById(long id);
	public Optional<EmployeesDao> selOnce(long idEmployees);

}
