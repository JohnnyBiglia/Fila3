package it.its.testEmployeesDB.services;

import java.util.List;
import java.util.Optional;

import it.its.testEmployeesDB.dao.ProvincesDao;
import it.its.testEmployeesDB.dao.RegionsDao;

public interface RegionsService {
	public List<RegionsDao> SelTutti();
	public Optional<RegionsDao> SelOnce(int idRegion);
}
