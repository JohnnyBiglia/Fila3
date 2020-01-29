package it.its.testEmployeesDB.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name = "Provinces")
@Data
public class ProvincesDao {
	
	@Id
	@Column(name = "Id")
	private String id;
	
	@Column(name = "Description")
	private String description;
}
