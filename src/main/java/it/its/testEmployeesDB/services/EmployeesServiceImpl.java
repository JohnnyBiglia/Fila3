package it.its.testEmployeesDB.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import it.its.testEmployeesDB.dao.EmployeesDao;
import it.its.testEmployeesDB.dto.EmployeesDto;
import it.its.testEmployeesDB.repository.EmployeesRepository;

@Service
@Transactional
public class EmployeesServiceImpl implements EmployeesService {

	@Autowired
	EmployeesRepository dipendentiRepository;

	@Override
	public List<EmployeesDto> SelTutti() {
		List<EmployeesDao> dao = dipendentiRepository.findAll();
		ArrayList<EmployeesDto> dto = new ArrayList<EmployeesDto>();
		for (EmployeesDao c : dao) {

			EmployeesDto temp = new EmployeesDto();
			temp.setId(c.getId());
			temp.setName(c.getName());
			temp.setSurname(c.getSurname());

			dto.add(temp);
		}
		return dto;
	}

	@Override
	public void deleteEmployeesById(int id) {
		dipendentiRepository.deleteById(id);
	}

	@Override
	public Optional<EmployeesDao> SelOnce(int id) {
		return dipendentiRepository.findById(id);
	}

	@Override
	public EmployeesDao update(EmployeesDao employeeDetails) {
		return dipendentiRepository.save(employeeDetails);
	}

	@Override
	public void create(EmployeesDao empl) {
		dipendentiRepository.saveAndFlush(empl);

	}

	@Override
	public Optional<EmployeesDao> filterEmployees(Map<String, String> allParams) {

		ExampleMatcher customExampleMatcher = ExampleMatcher.matchingAny().withMatcher("name",
				ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());

		String param = allParams.get("name");
		EmployeesDao prova = new EmployeesDao();
		prova.setName(param);
		Example<EmployeesDao> example = Example.of(prova, customExampleMatcher);

//		List<EmployeesDao> dao = dipendentiRepository.findAll();
//		ArrayList<EmployeesDto> dto = new ArrayList<EmployeesDto>();
//		for (EmployeesDao c : dao) {
//			if (param.equals("")) {
//				EmployeesDto temp = new EmployeesDto();
//				temp.setId(c.getId());
//				temp.setName(c.getName());
//				temp.setSurname(c.getSurname());
//
//				dto.add(temp);
//			} else if (param.equals(c.getName())) {
//				EmployeesDto temp = new EmployeesDto();
//				temp.setId(c.getId());
//				temp.setName(c.getName());
//				temp.setSurname(c.getSurname());
//
//				dto.add(temp);
//			} else if (param.equals(c.getSurname())) {
//				EmployeesDto temp = new EmployeesDto();
//				temp.setId(c.getId());
//				temp.setName(c.getName());
//				temp.setSurname(c.getSurname());
//
//				dto.add(temp);
//			} else if (param.equals(c.getEmail())) {
//				EmployeesDto temp = new EmployeesDto();
//				temp.setId(c.getId());
//				temp.setName(c.getName());
//				temp.setSurname(c.getSurname());
//
//				dto.add(temp);
//			}
//
//		}

		return dipendentiRepository.findOne(example);
	}
}
