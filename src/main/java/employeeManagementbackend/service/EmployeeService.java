package employeeManagementbackend.service;

import java.util.List;

import employeeManagementbackend.dto.EmployeeDto;

public interface EmployeeService {

	public EmployeeDto createEmployeeDto(EmployeeDto employeeDto);
	
	public EmployeeDto getEmployeeById(long id);
	
	
	public List<EmployeeDto> getAllEmployees();
	
	public EmployeeDto updateEmployee(long id,EmployeeDto updateEmployee);
	
	public void deleteById(long id);
}
