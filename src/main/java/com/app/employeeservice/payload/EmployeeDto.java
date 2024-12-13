package com.app.employeeservice.payload;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private  Long id;
    private  String name;
    private  String city;
    private String mobile;
    private String deptName;


}
