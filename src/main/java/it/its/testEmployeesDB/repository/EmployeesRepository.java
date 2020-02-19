package it.its.testEmployeesDB.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.its.testEmployeesDB.dao.EmployeesDao;

<<<<<<< HEAD
public interface EmployeesRepository extends JpaRepository<EmployeesDao, Long> {
=======
public interface EmployeesRepository extends JpaRepository<EmployeesDao, Integer>{
>>>>>>> refs/remotes/origin/updated_dao-dto

}
