package it.its.testEmployeesDB.dto;

import java.util.List;
import java.util.Optional;

import javax.persistence.Column;

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
	@Column(name = "id")
	private int id;

	@Column(name = "description")
	private String description;

}
