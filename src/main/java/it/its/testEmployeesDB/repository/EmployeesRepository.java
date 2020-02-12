package it.its.testEmployeesDB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD

import it.its.testEmployeesDB.dao.EmployeesDao;

public interface EmployeesRepository extends JpaRepository<EmployeesDao, Long>{
=======
import org.springframework.stereotype.Repository;

import it.its.testEmployeesDB.dao.EmployeesDao;

@Repository
public interface EmployeesRepository extends JpaRepository<EmployeesDao, Long> {
>>>>>>> refs/remotes/origin/test

}
