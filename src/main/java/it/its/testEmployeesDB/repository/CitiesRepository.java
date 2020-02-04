package it.its.testEmployeesDB.repository;

import javax.validation.Valid;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.its.testEmployeesDB.dao.CitiesDao;

@Repository
public interface CitiesRepository extends JpaRepository<CitiesDao, Long> {

	void save(@Valid User city);
	
}
