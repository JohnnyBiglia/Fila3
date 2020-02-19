package it.its.testEmployeesDB.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "employees")
@Data
public class EmployeesDao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8610876681283676856L;

	@Id
<<<<<<< HEAD
	@Column(name = "ID")
	private Long id;

=======
	@Column(name = "id")
	private int id;
	
>>>>>>> refs/remotes/origin/updated_dao-dto
	@Column(name = "name")
	private String name;
<<<<<<< HEAD

=======
	
>>>>>>> refs/remotes/origin/updated_dao-dto
	@Column(name = "surname")
	private String surname;
<<<<<<< HEAD

=======
	
>>>>>>> refs/remotes/origin/updated_dao-dto
	@Column(name = "email")
	private String email;

}
