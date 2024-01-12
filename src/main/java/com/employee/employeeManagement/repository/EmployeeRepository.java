package com.employee.employeeManagement.repository;

import com.employee.employeeManagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
