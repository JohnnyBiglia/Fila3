package it.its.testEmployeesDB.services;

import java.util.List;

import it.its.testEmployeesDB.dao.CitiesDao;

public interface CitiesService {
	public List<CitiesDao> SelTutti();

	public void create(CitiesDao city);
}
