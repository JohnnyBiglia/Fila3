package it.its.testEmployeesDB.dto;

import java.util.List;
import java.util.Optional;

import javax.persistence.Column;

import it.its.testEmployeesDB.dao.ProvincesDao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProvincesDto {

	private List<ProvincesDao> provincesData;
	private Optional<ProvincesDao> provincesDato;

	@Column(name = "id")
	private int id;

	@Column(name = "description")
	private String description;

}
