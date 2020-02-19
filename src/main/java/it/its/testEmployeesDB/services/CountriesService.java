package it.its.testEmployeesDB.services;

import java.util.List;

import it.its.testEmployeesDB.dao.CountriesDao;
import it.its.testEmployeesDB.dto.CountriesDto;

public interface CountriesService {
	public List<CountriesDto> SelTutti();
	public void deleteCountriesById(String iso);
}
