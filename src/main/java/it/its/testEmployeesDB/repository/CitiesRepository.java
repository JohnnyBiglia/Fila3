package it.its.testEmployeesDB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.StreamingHttpOutputMessage.Body;

import it.its.testEmployeesDB.dao.CitiesDao;

public interface CitiesRepository extends JpaRepository<CitiesDao, Long> {

}
