package it.its.testEmployeesDB.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.its.testEmployeesDB.dao.ProvincesDao;

public interface ProvincesRepository extends JpaRepository<ProvincesDao, Long> {

}
