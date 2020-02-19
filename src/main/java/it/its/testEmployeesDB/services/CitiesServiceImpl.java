package it.its.testEmployeesDB.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.its.testEmployeesDB.dao.CitiesDao;
import it.its.testEmployeesDB.dto.CitiesDto;
import it.its.testEmployeesDB.repository.CitiesRepository;

@Service
@Transactional
public class CitiesServiceImpl implements CitiesService{
	@Autowired
	CitiesRepository cittaRepository;

	@Override
	public List<CitiesDto> SelTutti() {
		List<CitiesDao>dao=cittaRepository.findAll();
		ArrayList<CitiesDto>dto=new ArrayList<CitiesDto>();
		for (CitiesDao c : dao) {
			CitiesDto temp=new CitiesDto();
			
			
			dto.add(temp);
		}
		
		return dto;
	}


	@Override
	public void deleteCitiesById(int id) {
		cittaRepository.deleteById(id);		
	}
}
