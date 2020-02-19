package it.its.testEmployeesDB.services;

import java.util.List;

import it.its.testEmployeesDB.dao.ProvincesDao;
import it.its.testEmployeesDB.dto.ProvincesDto;

public interface ProvincesService {
	public List<ProvincesDto> SelTutti();
	public void deleteProvincesById(int id);
}
