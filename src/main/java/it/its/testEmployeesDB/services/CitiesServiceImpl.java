package it.its.testEmployeesDB.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.its.testEmployeesDB.dao.CitiesDao;
import it.its.testEmployeesDB.repository.CitiesRepository;

@Service
@Transactional
public class CitiesServiceImpl implements CitiesService {
	@Autowired
	CitiesRepository cittaRepository;

	@Override
	public List<CitiesDao> SelTutti() {
		return cittaRepository.findAll();
	}

	@Override
	public CitiesDao update(CitiesDao city) {
		return cittaRepository.save(city);
	}
	
	public void create(CitiesDao city) {
		cittaRepository.saveAndFlush(city);
	}

	@Override
	public Optional<CitiesDao> SelOnce(int idCity) {
		// TODO Auto-generated method stub
		return cittaRepository.findById((long) idCity);
	}
}
