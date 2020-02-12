package it.its.testEmployeesDB.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.its.testEmployeesDB.dao.ProvincesDao;
import it.its.testEmployeesDB.repository.ProvincesRepository;

@Service
@Transactional
public class ProvincesServiceImpl implements ProvincesService {

	@Autowired
	ProvincesRepository provincesRepository;

	@Override
	public List<ProvincesDao> SelTutti() {
		return provincesRepository.findAll();
	}

	@Override
	public void deleteProvincesById(String id) {
		provincesRepository.deleteById(id);
		
	}

}
