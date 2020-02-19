package it.its.testEmployeesDB.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
<<<<<<< HEAD

@Table(name = "provinces")
@Table(name = "provinces")

@Data
public class ProvincesDao {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "description")
	private String description;

}
