package it.its.testEmployeesDB.dto;

import java.util.List;

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

}
