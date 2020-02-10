package it.its.testEmployeesDB.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Countries")
@Data
public class CountriesDao {

	@Id
	@Column(name = "iso")
	private long iso;

	@Column(name = "description")
	private String description;
}
