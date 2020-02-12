package it.its.testEmployees.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.its.testEmployees.dao.EmployeesDao;
import it.its.testEmployees.repository.EmployeesRepository;

@Service
@Transactional
public class EmployeesServiceImpl implements EmployeesService {

	@Autowired
	EmployeesRepository employeesRepository;

	@Override
	public List<EmployeesDao> SelTutti() {
		return employeesRepository.findAll();
	}

	@Override
	public void deleteEmployeesById(long id) {
		employeesRepository.deleteById(id); 
	}

	@Override
	public Optional<EmployeesDao> selOnce(long id) {
		return employeesRepository.findById(id);
	}

}