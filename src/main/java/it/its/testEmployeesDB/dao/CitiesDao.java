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
	@Column(name = "id")
	private int id;
<<<<<<< HEAD

=======
	
>>>>>>> refs/remotes/origin/updated_dao-dto
	@Column(name = "description")
	private String description;

	@Column(name = "id_province")
	private int province;

}
