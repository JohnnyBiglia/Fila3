package it.its.testEmployeesDB.dao;

<<<<<<< HEAD
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Employees")
@Data
public class EmployeesDao {

	@Id
	@Column(name = "id")
	private int id;

	
	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surname;

	@Column(name = "email")
	private String email;
}
=======
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
	@Column(name = "ID")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surname;

	@Column(name = "email")
	private String email;

}
>>>>>>> refs/remotes/origin/test
