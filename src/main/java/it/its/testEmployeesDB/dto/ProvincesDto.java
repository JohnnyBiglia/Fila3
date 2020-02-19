package it.its.testEmployeesDB.dto;

<<<<<<< HEAD
import java.util.List;
import java.util.Optional;
=======
import javax.persistence.Column;
import javax.persistence.Id;
>>>>>>> refs/remotes/origin/updated_dao-dto

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProvincesDto {
<<<<<<< HEAD
	private List<ProvincesDao> provincesData;
	private Optional<ProvincesDao> provincesDato;
=======
	
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "description")
	private String description;
>>>>>>> refs/remotes/origin/updated_dao-dto

}
