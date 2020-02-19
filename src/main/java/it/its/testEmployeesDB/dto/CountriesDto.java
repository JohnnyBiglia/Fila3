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

public class CountriesDto {
<<<<<<< HEAD
	private List<CountriesDao> countriesData;
	private Optional<CountriesDao> countriesDato;
=======
	@Id
	@Column(name = "iso")
	private String iso;
	
	@Column(name = "description")
	private String description;
>>>>>>> refs/remotes/origin/updated_dao-dto

}
