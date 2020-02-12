package it.its.testEmployeesDB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD

import it.its.testEmployeesDB.dao.ProvincesDao;

public interface ProvincesRepository extends JpaRepository<ProvincesDao, Long> {
=======
import org.springframework.stereotype.Repository;

import it.its.testEmployeesDB.dao.ProvincesDao;

@Repository
public interface ProvincesRepository extends JpaRepository<ProvincesDao, Long> {

	void deleteById(String id);
>>>>>>> refs/remotes/origin/test

}
