package com.employee.employeeManagement.service.impl;

import com.employee.employeeManagement.dto.EmployeeDto;
import com.employee.employeeManagement.entity.Employee;
import com.employee.employeeManagement.exception.ResourceNotFoundException;
import com.employee.employeeManagement.repository.EmployeeRepository;
import com.employee.employeeManagement.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository;
    ModelMapper modelMapper;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        Employee newEmployee = employeeRepository.save(employee);
        return modelMapper.map(newEmployee,EmployeeDto.class);
    }


    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto,Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id:" + employeeId));
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());

        Employee newEmployee = employeeRepository.save(employee);
        return modelMapper.map(newEmployee,EmployeeDto.class);

    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id:" + employeeId));
        employeeRepository.delete(employee);

    }

    @Override
    public EmployeeDto getEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id:" + employeeId));

        return modelMapper.map(employee,EmployeeDto.class);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> allEmployees = employeeRepository.findAll();
        List<EmployeeDto> allEmployeeDtos = allEmployees.stream()
                .map((employee)->modelMapper.map(employee, EmployeeDto.class)).collect(Collectors.toList());
        return allEmployeeDtos;
    }
}
