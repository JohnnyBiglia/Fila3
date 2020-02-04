package it.its.testEmployeesDB.services;

import java.util.List;

import it.its.testEmployeesDB.dao.RegionsDao;

public interface RegionsService {
	public List<RegionsDao> SelTutti();

	public RegionsDao update(RegionsDao region);
}
