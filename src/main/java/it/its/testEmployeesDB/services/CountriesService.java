package it.its.testEmployeesDB.services;

import java.util.List;
import java.util.Optional;

import it.its.testEmployeesDB.dao.CountriesDao;
<<<<<<< HEAD
import it.its.testEmployeesDB.dao.EmployeesDao;
=======
import it.its.testEmployeesDB.dto.CountriesDto;
>>>>>>> refs/remotes/origin/updated_dao-dto

public interface CountriesService {
<<<<<<< HEAD
	
	public List<CountriesDao> SelTutti();

	public CountriesDao update(CountriesDao country);
	
	public void create(CountriesDao country);

	public Optional<CountriesDao> SelOnce(String idCountry);
	
	public void deleteCountriesById(String isoCountries);
=======
	public List<CountriesDto> SelTutti();
	public void deleteCountriesById(String iso);
>>>>>>> refs/remotes/origin/updated_dao-dto
}
