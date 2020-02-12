package it.its.testEmployeesDB.services;

import java.util.List;

import it.its.testEmployeesDB.dao.ProvincesDao;

public interface ProvincesService {
	public List<ProvincesDao> SelTutti();

	public void deleteProvincesById(String id);
}
