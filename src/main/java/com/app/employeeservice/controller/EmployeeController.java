package com.app.employeeservice.controller;


import com.app.employeeservice.client.OpenFeignClient;
import com.app.employeeservice.payload.ApiResponseDto;
import com.app.employeeservice.payload.DepartmentDto;
import com.app.employeeservice.payload.EmployeeDto;
import com.app.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final RestTemplate restTemplate;
    private  final OpenFeignClient openFeignClient;

    // create Employee
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){

        return new ResponseEntity<>(employeeService.createEmployee(employeeDto), HttpStatus.CREATED);

    }

//    ------------------------------------------------------------------------------------

    // Get By Id

//    @GetMapping("/{id}")
//    public EmployeeDto getEmployeeById(@PathVariable long id){
//        return employeeService.getEmployeeById(id);
//    }

    // in case of rest or link to department


//    public ApiResponseDto getEmployeeById(@PathVariable long id){ // or
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDto> getEmployeeById(@PathVariable long id){
        EmployeeDto employeeDto =  employeeService.getEmployeeById(id);
        //case of rest
//        ResponseEntity<DepartmentDto> forEntity = restTemplate.getForEntity("http://localhost:8090/api/departments/"+ id, DepartmentDto.class);
//        DepartmentDto departmentDto = forEntity.getBody();


        // in case of OpenFeignClient

        DepartmentDto departmentDto = openFeignClient.getDepartmentById(id);

        ApiResponseDto apiResponseDto = new ApiResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);
        return ResponseEntity.ok(apiResponseDto);
//        return apiResponseDto;
    }



//    ------------------------------------------------------------------------------------
}
