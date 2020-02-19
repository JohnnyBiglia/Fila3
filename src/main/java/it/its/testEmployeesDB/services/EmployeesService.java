package it.its.testEmployeesDB.services;

import java.util.List;

import it.its.testEmployeesDB.dao.EmployeesDao;
import it.its.testEmployeesDB.dto.EmployeesDto;

public interface EmployeesService {
	public List<EmployeesDto> SelTutti();
	public void deleteEmployeesById(int id);
}
