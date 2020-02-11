package it.its.testEmployeesDB.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name = "Cities")
@Data
public class CitiesDao {
	@Id
	@Column(name = "Id")
	private int id;
	
	@Column(name = "Description")
	private String description;
}
