package com.employee.employeeManagement.Repository;

import com.employee.employeeManagement.Entity.Employee;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
@DataJpaTest
public class EmployeeRepositoryTest {
    @Autowired
    private EmployeeRepository employeeRepository;
    private Employee employee;

    @BeforeEach
    void setUp() {
        employee = Employee.builder()
                .id(Long.valueOf("1"))
                .firstName("John")
                .lastName("Doe")
                .email("john@gmail.com")
                .password("john")
                .build();
    }

    // given when then

    @DisplayName("Test For Employee Save Action")
    @Test
    public void Employee_Save_SavedEmployee(){
        Employee savedEmployee = employeeRepository.save(employee);

        Assertions.assertTrue(savedEmployee != null);
        Assertions.assertTrue(savedEmployee.getId() > 0);
    }

    @DisplayName("Test For Get Employee By Id Action")
    @Test
    public void Get_EmployeeById(){
        Employee employeeDb = employeeRepository.findById(employee.getId()).get();

        Assertions.assertTrue(employeeDb != null);

    }
    @DisplayName("Test For Get Employee Action")
    @Test
    public void Get_AllEmployees (){
        List<Employee> allEmployees = employeeRepository.findAll();

        Assertions.assertTrue(allEmployees != null);
        Assertions.assertTrue(allEmployees.size() > 0);
    }


    @AfterEach
    void tearDown() {

    }
}
