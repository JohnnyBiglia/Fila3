package it.its.testEmployeesDB.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.its.testEmployeesDB.dao.ProvincesDao;
import it.its.testEmployeesDB.dto.ProvincesDto;
import it.its.testEmployeesDB.repository.ProvincesRepository;


@Service
@Transactional
public class ProvincesServiceImpl implements ProvincesService{
	
	@Autowired
	ProvincesRepository provincieRepository;

	@Override
	public List<ProvincesDto> SelTutti() {
		List<ProvincesDao>dao=provincieRepository.findAll();
		ArrayList<ProvincesDto>dto=new ArrayList<ProvincesDto>();
		for(ProvincesDao d:dao) {
			ProvincesDto temp=new ProvincesDto();
			temp.setId(d.getId());
			temp.setDescription(d.getDescription());
			
			dto.add(temp);
			
		}
		return dto;
	}
	public void deleteProvincesById(long id) {
		provincieRepository.deleteById(id);
	}
}
