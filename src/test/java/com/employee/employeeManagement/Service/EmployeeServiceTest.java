package com.employee.employeeManagement.Service;

import com.employee.employeeManagement.Dto.EmployeeDto;
import com.employee.employeeManagement.Entity.Employee;
import com.employee.employeeManagement.Exception.ResourceNotFoundException;
import com.employee.employeeManagement.Repository.EmployeeRepository;
import com.employee.employeeManagement.Service.Impl.EmployeeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;
    @InjectMocks
    private EmployeeServiceImpl employeeService;

    private Employee employee;
    private EmployeeDto employeeDto;

    @BeforeEach
    void setUp() {
        employee = Employee.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john@gmail.com")
                .password("john")
                .build();
        employeeDto = EmployeeDto.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john@gmail.com")
                .password("john")
                .build();
    }

    @Test
    public void Employee_Save_SavedEmployee(){
        given(employeeRepository.save(employee)).willReturn(employee);
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);

        Assertions.assertTrue(savedEmployee != null);

    }
    @Test
    public void Employee_Update_UpdatedEmployee(){
        given(employeeRepository.findById(employee.getId())).willReturn(Optional.of(employee));
        given(employeeRepository.save(employee)).willReturn(employee);
        employeeDto.setEmail("test@gmail.com");
        EmployeeDto updatedEmployee = employeeService.updateEmployee(employeeDto, employeeDto.getId());

        Assertions.assertEquals(updatedEmployee.getEmail(),employeeDto.getEmail());

    }
    @Test
    public void Employee_Update_NotUpdatedEmployee(){
        given(employeeRepository.findById(employee.getId())).willReturn(Optional.of(employee));

        Assertions.assertThrows(ResourceNotFoundException.class,() ->{
            employeeService.updateEmployee(employeeDto, employeeDto.getId());
        });

        verify(employeeRepository,never()).save(any(Employee.class));
    }

    @Test
    public void Employee_Delete_Employee(){
        long id = 1L;
        willDoNothing().given(employeeRepository).deleteById(id);
        employeeService.deleteEmployee(id);
        verify(employeeRepository,times(1)).deleteById(id);
    }

}
