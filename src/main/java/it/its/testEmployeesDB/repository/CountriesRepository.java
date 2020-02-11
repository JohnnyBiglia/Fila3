package it.its.testEmployeesDB.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.its.testEmployeesDB.dao.CountriesDao;


public interface CountriesRepository extends JpaRepository<CountriesDao, Long>{

	Optional<CountriesDao> findByIso(String idCountry);

}
