package it.its.testEmployeesDB.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class UserDao {
	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String nome;

	@Column(name = "password")
	private String password;
	
	@Column(name="ruolo")
	private String ruolo;
	
	@Column(name="config")
	private String config;
	

}
