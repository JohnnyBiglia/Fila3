package it.its.testEmployeesDB.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.its.testEmployeesDB.dao.CountriesDao;
import it.its.testEmployeesDB.dto.CountriesDto;
import it.its.testEmployeesDB.repository.CountriesRepository;

@Service
@Transactional
public class CountriesServiceImpl implements CountriesService{
	@Autowired
	CountriesRepository countriesRepository;

	@Override
	public List<CountriesDto> SelTutti() {
		List<CountriesDao>dao=countriesRepository.findAll();
		ArrayList<CountriesDto>dto=new ArrayList<CountriesDto>();
		for (CountriesDao d : dao) {
			CountriesDto temp=new CountriesDto();
			temp.setIso(d.getIso());
			temp.setDescription(d.getDescription());
			
			dto.add(temp);
			
			

	}
	return dto;	
		
		
		
	}

	@Override
	public void deleteCountriesById(long iso) {
		countriesRepository.deleteById(iso);
		
	}


}
