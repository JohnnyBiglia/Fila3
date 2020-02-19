package it.its.testEmployeesDB.services;

import java.util.List;
import java.util.Optional;

import it.its.testEmployeesDB.dao.ProvincesDao;
import it.its.testEmployeesDB.dto.ProvincesDto;

public interface ProvincesService {
<<<<<<< HEAD

	public List<ProvincesDao> SelTutti();

	public ProvincesDao update(ProvincesDao province);

	public void create(ProvincesDao province);

	public Optional<ProvincesDao> SelOnce(int idProvince);

=======
	public List<ProvincesDto> SelTutti();
>>>>>>> refs/remotes/origin/updated_dao-dto
	public void deleteProvincesById(int id);
}
