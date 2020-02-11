package it.its.testEmployeesDB.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.its.testEmployeesDB.dao.EmployeesDao;
import it.its.testEmployeesDB.repository.EmployeesRepository;

@Service
@Transactional
public class EmployeesServiceImpl implements EmployeesService{

	@Autowired
	EmployeesRepository dipendentiRepository;

	@Override
	public List<EmployeesDao> SelTutti() {
		return dipendentiRepository.findAll();
	}

	@Override
	public  Optional<EmployeesDao> SelOnce(int id) {
		// TODO Auto-generated method stub
		return dipendentiRepository.findById((long) id);
	}
}
