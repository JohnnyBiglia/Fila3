package it.its.testEmployeesDB.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "regions")
@Data
public class RegionsDao {

	@Id
	@Column(name = "id")
	private int id;
<<<<<<< HEAD

=======
>>>>>>> refs/remotes/origin/updated_dao-dto
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "iso_country")
	private String isoCountry;
}
