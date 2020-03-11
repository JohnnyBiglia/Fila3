package it.its.testEmployeesDB.services;

import java.util.List;
import java.util.Optional;

import it.its.testEmployeesDB.dao.UserDao;
import it.its.testEmployeesDB.dao.UserDao;
import it.its.testEmployeesDB.dto.CitiesDto;
import it.its.testEmployeesDB.dto.UserDto;

public interface UserService {

	public List<UserDto> SelTutti();

	public UserDao update(UserDao user);

	public void create(UserDao user);

	public Optional<UserDao> SelOnce(int idUser);

	public void deleteUserById(int id);
}
