package it.its.testEmployeesDB.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.its.testEmployeesDB.dao.ProvincesDao;
import it.its.testEmployeesDB.dto.ProvincesDto;
import it.its.testEmployeesDB.repository.ProvincesRepository;

@Service
@Transactional
<<<<<<< HEAD
public class ProvincesServiceImpl implements ProvincesService {
=======
public class ProvincesServiceImpl implements ProvincesService{
	
>>>>>>> refs/remotes/origin/updated_dao-dto
	@Autowired
	ProvincesRepository provinceRepository;

	@Override
<<<<<<< HEAD
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

=======
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
>>>>>>> refs/remotes/origin/updated_dao-dto
	}
	public void deleteProvincesById(int id) {
		provincieRepository.deleteById(id);
	}
	
}
