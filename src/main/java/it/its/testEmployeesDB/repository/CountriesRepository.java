package it.its.testEmployeesDB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.its.testEmployeesDB.dao.CountriesDao;

@Repository
public interface CountriesRepository extends JpaRepository<CountriesDao, Long> {

	void deleteById(String id);

	

}
