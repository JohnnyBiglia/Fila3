package it.its.testEmployeesDB.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "cities")
@Data
public class CitiesDao {
	@Id
<<<<<<< HEAD
	@Column(name = "id")
=======
	@Column(name = "Id")
>>>>>>> refs/heads/fetchOnce
	private long id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "id_province")
	private int province;
}
