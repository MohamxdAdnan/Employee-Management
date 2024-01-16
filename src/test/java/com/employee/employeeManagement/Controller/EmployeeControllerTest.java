package com.employee.employeeManagement.Controller;

import com.employee.employeeManagement.Dto.EmployeeDto;
import com.employee.employeeManagement.Entity.Employee;
import com.employee.employeeManagement.Service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.modelmapper.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Autowired
    private ObjectMapper objectMapper;

    private Employee employee;

    @BeforeEach
    void setUp() {
        employee = Employee.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john@gmail.com")
                .password("john")
                .build();
    }

    @Test
    public void givenEmployee_whenCreateEmployee_thenReturnSavedEmployee() throws Exception {
        given(employeeService.createEmployee(any(EmployeeDto.class)))
                .willAnswer((invocationOnMock -> invocationOnMock.getArgument(0)));
//    ERROR HERE !!
//       ResultActions response = mockMvc.perform(post("/api/employees"))
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(employee));
//
//       response.andExpect(status().isCreated())
//               .andExpect(jsonPath("$.firstName",is(employee.getFirstName()));
    }



}
