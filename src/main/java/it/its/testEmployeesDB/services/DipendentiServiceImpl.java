package it.its.testEmployeesDB.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.its.testEmployeesDB.dao.EmployeesDao;
import it.its.testEmployeesDB.dto.EmployeesDto;
import it.its.testEmployeesDB.repository.EmployeesRepository;

@Service
@Transactional
public class DipendentiServiceImpl implements EmployeesService{

	@Autowired
	EmployeesRepository employeesRepository;

	@Override
	public List<EmployeesDto> SelTutti() {
		List<EmployeesDao>dao=employeesRepository.findAll();
		ArrayList<EmployeesDto>dto=new ArrayList<EmployeesDto>();
		for(EmployeesDao d:dao) {
			
			EmployeesDto temp=new EmployeesDto();
			temp.setId(d.getId());
			temp.setName(d.getName());
			temp.setSurname(d.getSurname());
			
			dto.add(temp);
			
			
		}
		return dto;
	}
	
	public void deleteEmployeesById(long id) {
		employeesRepository.deleteById(id);
	}
	
	
//	public ArrayList<EmployeesDto> selTutti(){
//		ArrayList<EmployeesDto>dto=new ArrayList<EmployeesDto>();
//		List<EmployeesDao>dao=this.SelTutti();
//		
//		for(EmployeesDao d:dao) {
//			
//			EmployeesDto temp=new EmployeesDto();
//			temp.setId(Long.parseLong(d.getId()));
//			temp.setName(d.getName());
//			temp.setSurname(d.getSurname());
//			
//			dto.add(temp);
//			
//			
//		}
//		return dto;
//	}
}
