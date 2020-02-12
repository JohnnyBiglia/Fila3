package it.its.testEmployeesDB.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.its.testEmployeesDB.dao.CountriesDao;

public interface CountriesRepository extends JpaRepository<CountriesDao, String> {

}
