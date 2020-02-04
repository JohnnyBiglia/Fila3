package it.its.testEmployeesDB.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "cities")
@Data
@Getter
@Setter
public class CitiesDao {
	@Id
	@Column(name = "id")
	private long id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "id_province")
	private int province;
}
 