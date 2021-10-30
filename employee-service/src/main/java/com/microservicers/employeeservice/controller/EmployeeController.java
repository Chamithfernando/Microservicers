package com.microservicers.employeeservice.controller;

import com.microservicers.employeeservice.entity.Employee;
import com.microservicers.employeeservice.service.EmployeeService;
import com.microservicers.employeeservice.vo.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/")
    public Employee saveEmployee(@RequestBody Employee employee){
        log.info("Inside Save employee method of employee controller");
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getEmployeeWithDepartment(@PathVariable("id") Long employeeId){
        log.info("Inside getEmployeeWithDepartment  method of employee controller");
        return employeeService.getEmployeeWithDepartment(employeeId);
    }




}
