package it.its.testEmployeesDB.services;

import java.util.List;

import it.its.testEmployeesDB.dao.CountriesDao;

public interface CountriesService {
	public List<CountriesDao> SelTutti();

	public CountriesDao update(CountriesDao country);
}
