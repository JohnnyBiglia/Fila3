package it.its.testEmployeesDB.services;

import java.util.List;
import java.util.Optional;

import it.its.testEmployeesDB.dao.CitiesDao;
import it.its.testEmployeesDB.dto.CitiesDto;

public interface CitiesService {

	public List<CitiesDto> SelTutti();

	public CitiesDao update(CitiesDao city);

	public void create(CitiesDao city);

	public Optional<CitiesDao> SelOnce(int idCity);

	public void deleteCitiesById(int id);
}
