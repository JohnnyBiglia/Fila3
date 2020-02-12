package it.its.testEmployeesDB.services;

import java.util.List;
import java.util.Optional;

import it.its.testEmployeesDB.dao.ProvincesDao;

public interface ProvincesService {
	
	public List<ProvincesDao> SelTutti();

	public ProvincesDao update(ProvincesDao province);

	public void create(ProvincesDao province);

	public Optional<ProvincesDao> SelOnce(int idProvince);
	
	public void deleteProvincesById(String id);
}
