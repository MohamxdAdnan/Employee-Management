package com.employee.employeeManagement.service;

import com.employee.employeeManagement.dto.EmployeeDto;

import java.util.List;


public interface EmployeeService {

    EmployeeDto createEmployee (EmployeeDto employeeDto);
    EmployeeDto updateEmployee (EmployeeDto employeeDto,Long employeeId);
    void deleteEmployee (Long employeeId);
    EmployeeDto getEmployee (Long employeeId);
    List<EmployeeDto> getAllEmployees ();

}
