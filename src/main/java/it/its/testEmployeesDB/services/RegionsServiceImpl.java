package it.its.testEmployeesDB.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.its.testEmployeesDB.dao.RegionsDao;
import it.its.testEmployeesDB.dto.RegionsDto;
import it.its.testEmployeesDB.repository.RegionsRepository;

@Service
@Transactional
public class RegionsServiceImpl implements RegionsService {
	@Autowired
	RegionsRepository regioniRepository;

	@Override
	public List<RegionsDto> SelTutti() {
		List<RegionsDao> dao = regioniRepository.findAll();
		ArrayList<RegionsDto> dto = new ArrayList<RegionsDto>();
		for (RegionsDao r : dao) {
			RegionsDto temp = new RegionsDto();
			temp.setId(r.getId());
			temp.setDescription(r.getDescription());

			dto.add(temp);
		}
		return dto;
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
	public Optional<RegionsDao> SelOnce(int idRegion) {
		// TODO Auto-generated method stub
		return regioniRepository.findById(idRegion);
	}

	@Override
	public void deleteRegionsById(int idRegions) {
		regioniRepository.deleteById(idRegions);

	}
}
