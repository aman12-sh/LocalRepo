package com.app.employeeservice.payload;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseDto {

    private EmployeeDto employeeDto;
    private DepartmentDto departmentDto;
}
