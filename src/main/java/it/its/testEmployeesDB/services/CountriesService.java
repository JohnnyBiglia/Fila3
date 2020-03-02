package it.its.testEmployeesDB.services;

import java.util.List;
import java.util.Optional;

import it.its.testEmployeesDB.dao.CountriesDao;
import it.its.testEmployeesDB.dto.CountriesDto;

public interface CountriesService {

	public List<CountriesDto> SelTutti();

	public CountriesDao update(CountriesDao country);

	public void create(CountriesDao country);

	public Optional<CountriesDao> SelOnce(String idCountry);

	public void deleteCountriesById(String isoCountries);

}
