package it.its.testEmployeesDB.services;

import java.util.List;
import java.util.Optional;

import it.its.testEmployeesDB.dao.RegionsDao;
import it.its.testEmployeesDB.dto.RegionsDto;

public interface RegionsService {
<<<<<<< HEAD
	public List<RegionsDao> SelTutti();

	public RegionsDao update(RegionsDao region);

	public void create(RegionsDao region);

	public Optional<RegionsDao> SelOnce(int idRegion);

	public void deleteRegionsById(int idRegions);
=======
	public List<RegionsDto> SelTutti();
	public void deleteRegionsById(int id);
>>>>>>> refs/remotes/origin/updated_dao-dto
}
