package employeeManagementbackend.service.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import employeeManagementbackend.EmployeeMapper.EmployeeMapper;
import employeeManagementbackend.dto.EmployeeDto;
import employeeManagementbackend.entity.Employee;
import employeeManagementbackend.exception.ResoucreNotFoundException;
import employeeManagementbackend.repositry.EmployeeRepositry;
import employeeManagementbackend.service.EmployeeService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepositry employeeRepositry;
	@Override
	public EmployeeDto createEmployeeDto(EmployeeDto employeeDto) {
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		Employee savedEmployee = employeeRepositry.save(employee);
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}
	
	
	@Override
	public EmployeeDto getEmployeeById(long id) {
		Employee employee = employeeRepositry.findById(id)
				.orElseThrow(()-> 
				new ResoucreNotFoundException("Employee is not exist with given id "+id));
		return EmployeeMapper.mapToEmployeeDto(employee);
	}
	
	
	@Override
	public List<EmployeeDto> getAllEmployees() {
		 List<Employee> employees = employeeRepositry.findAll();
		return employees.stream().map((employee)->EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
	}
	
	
	@Override
	public EmployeeDto updateEmployee(long id, EmployeeDto updateEmployee) {
		
		Employee employee = employeeRepositry.findById(id)
				.orElseThrow(()->
				new ResoucreNotFoundException("Employee is Not Exis with give id "+ id));
		
		employee.setFirstName(updateEmployee.getFirstName());
		employee.setLastName(updateEmployee.getLastName());
		employee.setEmail(updateEmployee.getEmail());
		
		Employee updateEmployee1 = employeeRepositry.save(employee);
		return EmployeeMapper.mapToEmployeeDto(updateEmployee1);
	}


	@Override
	public void deleteById(long id) {
		
		Employee employee = employeeRepositry.findById(id).orElseThrow(()-> new ResoucreNotFoundException("Employee is Not Exist With give id"+id));
		
		employeeRepositry.deleteById(id);
		
	}
	
	

}
