package it.its.testEmployeesDB.services;

import java.util.List;

import it.its.testEmployeesDB.dao.CitiesDao;
import it.its.testEmployeesDB.dto.CitiesDto;

public interface CitiesService {
	public List<CitiesDto> SelTutti();
	public void deleteCitiesById(int id);
}
