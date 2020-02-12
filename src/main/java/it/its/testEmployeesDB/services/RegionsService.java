package it.its.testEmployeesDB.services;

import java.util.List;

import it.its.testEmployeesDB.dao.RegionsDao;

public interface RegionsService {

	public List<RegionsDao> SelTutti();

	public void deleteRegionsById(String idRegions);

}
