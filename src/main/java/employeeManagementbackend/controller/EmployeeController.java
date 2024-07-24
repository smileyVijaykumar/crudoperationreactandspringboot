package employeeManagementbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import employeeManagementbackend.EmployeeMapper.EmployeeMapper;
import employeeManagementbackend.dto.EmployeeDto;
import employeeManagementbackend.entity.Employee;
import employeeManagementbackend.service.EmployeeService;

@CrossOrigin("*")
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/add")
	public  ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
		EmployeeDto saveEmployeeDto = employeeService.createEmployeeDto(employeeDto);
		return new ResponseEntity<>(saveEmployeeDto,HttpStatus.CREATED) ;
		
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<EmployeeDto> getById(@PathVariable long id){
		
		 EmployeeDto employeeDto = employeeService.getEmployeeById(id);
		 
		 return ResponseEntity.ok(employeeDto);
		
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<EmployeeDto>> getAllEmployeeDetails(){
		 List<EmployeeDto> employee= employeeService.getAllEmployees();
		 
		 return ResponseEntity.ok(employee);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable long id, @RequestBody EmployeeDto updateEmployee){
		
		EmployeeDto employeeDto = employeeService.updateEmployee(id, updateEmployee);
		return ResponseEntity.ok(employeeDto);
		
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable long id){
		   employeeService.deleteById(id);
		   
		   return ResponseEntity.ok("Employee Deleted Sucessfully!.");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
