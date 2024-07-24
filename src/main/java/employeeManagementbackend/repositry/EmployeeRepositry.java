package employeeManagementbackend.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import employeeManagementbackend.entity.Employee;
@Repository
public interface EmployeeRepositry extends JpaRepository<Employee, Long> {

}
