package it.its.testEmployeesDB.repository;

<<<<<<< HEAD
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.its.testEmployeesDB.dao.CountriesDao;


public interface CountriesRepository extends JpaRepository<CountriesDao, String>{

=======
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.its.testEmployeesDB.dao.CountriesDao;

@Repository
public interface CountriesRepository extends JpaRepository<CountriesDao, String> {



	
>>>>>>> refs/remotes/origin/test

}
