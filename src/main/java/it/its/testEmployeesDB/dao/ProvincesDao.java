package it.its.testEmployeesDB.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
<<<<<<< HEAD

@Table(name = "Provinces")
=======
@Table(name = "provinces")
>>>>>>> refs/remotes/origin/updated_dao-dto
@Data
public class ProvincesDao {

	@Id
	@Column(name = "id")
	private int id;
<<<<<<< HEAD

=======
	
>>>>>>> refs/remotes/origin/updated_dao-dto
	@Column(name = "description")
	private String description;

}
