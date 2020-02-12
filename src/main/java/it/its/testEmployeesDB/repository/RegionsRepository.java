package it.its.testEmployeesDB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD

import it.its.testEmployeesDB.dao.RegionsDao;

public interface RegionsRepository extends JpaRepository<RegionsDao, Long> {
=======
import org.springframework.stereotype.Repository;

import it.its.testEmployeesDB.dao.RegionsDao;

@Repository
public interface RegionsRepository extends JpaRepository<RegionsDao, Long> {

	void deleteById(String idRegions);
>>>>>>> refs/remotes/origin/test

}
