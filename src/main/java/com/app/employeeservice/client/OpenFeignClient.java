package com.app.employeeservice.client;

import com.app.employeeservice.payload.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url = "http://localhost:8090/api/departments",value = "DEPARTMENT-SERVICE")

// in case load balancer

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface OpenFeignClient {

    @GetMapping("api/departments/{id}")
    public DepartmentDto getDepartmentById(@PathVariable long id);

}
