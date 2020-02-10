package it.its.testEmployeesDB.services;

import java.util.List;
import java.util.Optional;

import it.its.testEmployeesDB.dao.CitiesDao;

public interface CitiesService {
	public List<CitiesDao> SelTutti();

	public Optional<CitiesDao> SelOnce(long idCity);
}
