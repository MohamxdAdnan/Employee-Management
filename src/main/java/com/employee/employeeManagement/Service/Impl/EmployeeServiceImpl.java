package com.employee.employeeManagement.Service.Impl;

import com.employee.employeeManagement.Dto.EmployeeDto;
import com.employee.employeeManagement.Entity.Employee;
import com.employee.employeeManagement.Exception.ResourceNotFoundException;
import com.employee.employeeManagement.Repository.EmployeeRepository;
import com.employee.employeeManagement.Service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
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
