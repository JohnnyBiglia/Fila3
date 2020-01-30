package it.its.testEmployeesDB.services;

import java.util.List;

import it.its.testEmployeesDB.dao.CitiesDao;
import it.its.testEmployeesDB.repository.CitiesRepository;

public interface CitiesService {
	public List<CitiesDao> SelTutti();
	
	public static final CitiesRepository cittaRepository = null;
	
	public static CitiesDao createCity(CitiesDao citydao) {
		CitiesDao newCity = new CitiesDao();

		newCity.setDescription(citydao.getDescription());
		newCity.setProvince(citydao.getProvince());
		return cittaRepository.save(newCity);
	}
}
