package it.its.testEmployeesDB.services;

import java.util.List;
import java.util.Optional;

import it.its.testEmployeesDB.dao.ProvincesDao;
import it.its.testEmployeesDB.dto.ProvincesDto;

public interface ProvincesService {

	public List<ProvincesDto> SelTutti();

	public ProvincesDao update(ProvincesDao province);

	public void create(ProvincesDao province);

	public Optional<ProvincesDao> SelOnce(int idProvince);

	public void deleteProvincesById(int id);
}
