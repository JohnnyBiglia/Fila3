package it.its.testEmployeesDB.services;

import java.util.List;
import java.util.Optional;

import it.its.testEmployeesDB.dao.ProvincesDao;

public interface ProvincesService {
	public List<ProvincesDao> SelTutti();

	public Optional<ProvincesDao> SelOnce(long idProvince);
}
