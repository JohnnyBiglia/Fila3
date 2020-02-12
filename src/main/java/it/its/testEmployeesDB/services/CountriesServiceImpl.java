package it.its.testEmployeesDB.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.its.testEmployeesDB.dao.CountriesDao;
import it.its.testEmployeesDB.repository.CountriesRepository;

@Service
@Transactional
public class CountriesServiceImpl implements CountriesService {

	@Autowired
	CountriesRepository countriesRepository;

	@Override
	public List<CountriesDao> SelTutti() {
		return countriesRepository.findAll();
	}

	@Override
	public void deleteCountriesById(String id) {
		countriesRepository.deleteById(id);
		
	}

	

}
