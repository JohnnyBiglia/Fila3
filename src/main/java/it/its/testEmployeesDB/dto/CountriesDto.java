package it.its.testEmployeesDB.dto;

import java.util.List;
<<<<<<< HEAD
import java.util.Optional;

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

=======

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
>>>>>>> refs/remotes/origin/test
}
