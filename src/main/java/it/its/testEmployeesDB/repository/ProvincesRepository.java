package it.its.testEmployeesDB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.its.testEmployeesDB.dao.ProvincesDao;

@Repository
public interface ProvincesRepository extends JpaRepository<ProvincesDao, Long> {

	void deleteById(String id);

}
