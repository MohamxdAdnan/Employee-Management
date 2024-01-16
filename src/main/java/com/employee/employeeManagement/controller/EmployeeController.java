package com.employee.employeeManagement.controller;

import com.employee.employeeManagement.dto.EmployeeDto;
import com.employee.employeeManagement.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

//    @GetMapping("/home")
//    public String home() {
//        return "index";
//    }
//
//    @GetMapping("/employees")
//    public String employee() {
//        return "employees";
//    }
//
//    @GetMapping("/new_employee")
//    public String newEmployee() {
//        return "index";
//    }

    @PostMapping("/create")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto createdEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable Long id) {
        EmployeeDto employeeDto = employeeService.getEmployee(id);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> allEmployees = employeeService.getAllEmployees();
        return new ResponseEntity<>(allEmployees, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Employee deleted", HttpStatus.NO_CONTENT);
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto, @PathVariable Long id) {
        EmployeeDto updatedEmployee = employeeService.updateEmployee(employeeDto, id);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }
}
