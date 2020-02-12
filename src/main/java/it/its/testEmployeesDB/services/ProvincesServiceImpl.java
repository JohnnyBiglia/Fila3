package it.its.testEmployeesDB.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.its.testEmployeesDB.dao.ProvincesDao;
import it.its.testEmployeesDB.repository.ProvincesRepository;

@Service
@Transactional
public class ProvincesServiceImpl implements ProvincesService {
	@Autowired
	ProvincesRepository provinceRepository;

	@Override
	public List<ProvincesDao> SelTutti() {
		return provinceRepository.findAll();
	}

	@Override
	public ProvincesDao update(ProvincesDao province) {
		return provinceRepository.save(province);
	}

	@Override
	public void create(ProvincesDao province) {
		provinceRepository.saveAndFlush(province);
	}

	@Override
	public Optional<ProvincesDao> SelOnce(int idProvince) {
		return provinceRepository.findById(idProvince);
	}

	@Override
	public void deleteProvincesById(int id) {
		provinceRepository.deleteById(id);

	}
}
