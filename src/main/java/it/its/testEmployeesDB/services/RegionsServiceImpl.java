package it.its.testEmployeesDB.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.its.testEmployeesDB.dao.RegionsDao;
import it.its.testEmployeesDB.repository.RegionsRepository;

@Service
@Transactional
public class RegionsServiceImpl implements RegionsService {
	@Autowired
	RegionsRepository regioniRepository;

	@Override
	public List<RegionsDao> SelTutti() {
		return regioniRepository.findAll();
	}

	@Override
	public RegionsDao update(RegionsDao region) {
		return regioniRepository.save(region);
	}

	@Override
	public void create(RegionsDao region) {
		regioniRepository.saveAndFlush(region);
	}

	@Override
	public Optional<RegionsDao> SelOnce(long idRegion) {
		// TODO Auto-generated method stub
		return regioniRepository.findById(idRegion);
	}
}
