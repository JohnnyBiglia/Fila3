package it.its.testEmployeesDB.dto;

import java.util.List;
<<<<<<< HEAD
import java.util.Optional;

import it.its.testEmployeesDB.dao.RegionsDao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegionsDto {
	private List<RegionsDao> regionsData;
	private Optional<RegionsDao> regionDato;

=======

import it.its.testEmployeesDB.dao.RegionsDao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegionsDto {
	private List<RegionsDao> regionsData;
>>>>>>> refs/remotes/origin/test
}
