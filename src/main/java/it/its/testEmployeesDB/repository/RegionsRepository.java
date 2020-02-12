package it.its.testEmployeesDB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.its.testEmployeesDB.dao.RegionsDao;

@Repository
public interface RegionsRepository extends JpaRepository<RegionsDao, Long> {

	void deleteById(String idRegions);

}
