package it.its.testEmployeesDB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.its.testEmployeesDB.dao.CitiesDao;
import it.its.testEmployeesDB.dao.UserDao;

@Repository

public interface UserRepository extends JpaRepository<UserDao, Integer> {

}
