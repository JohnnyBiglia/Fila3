package it.its.testEmployeesDB.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "countries")
@Data
public class CountriesDao {

	@Id
	@Column(name = "iso")
	private String iso;
<<<<<<< HEAD

=======
	
>>>>>>> refs/remotes/origin/updated_dao-dto
	@Column(name = "description")
	private String description;

}
