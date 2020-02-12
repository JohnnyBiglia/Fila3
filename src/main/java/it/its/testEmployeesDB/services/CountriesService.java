package it.its.testEmployeesDB.services;

import java.util.List;
import java.util.Optional;

import it.its.testEmployeesDB.dao.CountriesDao;
import it.its.testEmployeesDB.dao.EmployeesDao;

public interface CountriesService {
	
	public List<CountriesDao> SelTutti();

	public CountriesDao update(CountriesDao country);
	
	public void create(CountriesDao country);

	public Optional<CountriesDao> SelOnce(String idCountry);
}
