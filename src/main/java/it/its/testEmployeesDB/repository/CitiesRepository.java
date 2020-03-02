package it.its.testEmployeesDB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.its.testEmployeesDB.dao.CitiesDao;

@Repository

public interface CitiesRepository extends JpaRepository<CitiesDao, Integer> {

}
