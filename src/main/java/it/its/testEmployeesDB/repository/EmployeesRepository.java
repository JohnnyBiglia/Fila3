package it.its.testEmployeesDB.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.its.testEmployeesDB.dao.EmployeesDao;

public interface EmployeesRepository extends JpaRepository<EmployeesDao, Integer>{

}
