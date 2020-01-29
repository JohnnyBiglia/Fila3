package it.its.testEmployeesDB.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.its.testEmployeesDB.dao.RegionsDao;

public interface RegionsRepository extends JpaRepository<RegionsDao, Long> {

}
