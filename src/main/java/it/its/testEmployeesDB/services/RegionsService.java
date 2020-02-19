package it.its.testEmployeesDB.services;

import java.util.List;

import it.its.testEmployeesDB.dao.RegionsDao;
import it.its.testEmployeesDB.dto.RegionsDto;

public interface RegionsService {
	public List<RegionsDto> SelTutti();
	public void deleteRegionsById(int id);
}
