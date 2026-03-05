package in.cg.main.services;

import in.cg.main.dto.EmployeeDto;

public interface IEmployeeService {
	boolean deleteWithId(int id);
	EmployeeDto addUserDetails(EmployeeDto ud);
}
