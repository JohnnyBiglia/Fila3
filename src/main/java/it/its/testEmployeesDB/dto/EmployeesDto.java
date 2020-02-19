package it.its.testEmployeesDB.dto;

import java.util.List;
import java.util.Optional;

import javax.persistence.Column;

import it.its.testEmployeesDB.dao.EmployeesDao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
public class EmployeesDto {
<<<<<<< HEAD
	private List<EmployeesDao> dipendentiData;
	private Optional<EmployeesDao> dipendentiDato;

=======
	
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surname;

	
>>>>>>> refs/remotes/origin/updated_dao-dto
}
