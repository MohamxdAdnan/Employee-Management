package com.employee.employeeManagement.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(
        description = "Employee DTO Model Info"
)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private Long id;
    @Schema(
            description = "Employee Firstname"
    )
    private String firstName;
    @Schema(
            description = "Employee Lastname"
    )
    private String lastName;
    @Schema(
            description = "Employee Email"
    )
    private String email;
    @Schema(
            description = "Employee Password"
    )
    private String password;
}
