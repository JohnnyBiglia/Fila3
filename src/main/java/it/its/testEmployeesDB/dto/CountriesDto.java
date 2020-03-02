package it.its.testEmployeesDB.dto;

import java.util.List;
import java.util.Optional;

import javax.persistence.Column;

import it.its.testEmployeesDB.dao.CountriesDao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountriesDto {

	private List<CountriesDao> countriesData;
	private Optional<CountriesDao> countriesDato;

	@Column(name = "iso")
	private String iso;

	@Column(name = "description")
	private String description;

}
