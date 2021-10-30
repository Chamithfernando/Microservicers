package com.microservicers.employeeservice.service;

import com.microservicers.employeeservice.entity.Employee;
import com.microservicers.employeeservice.repository.EmployeeRepo;
import com.microservicers.employeeservice.vo.Departemnt;
import com.microservicers.employeeservice.vo.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private RestTemplate restTemplate;


    public Employee saveEmployee(Employee employee) {
        log.info("inside save employee method of EmployeeService");
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Long employeeId) {
        log.info("inside findEmployeebyid method of EmployeeService");
        return employeeRepo.findByEmployeeId(employeeId);
    }

    public ResponseTemplateVO getEmployeeWithDepartment(Long employeeId) {

        log.info("inside getEmployeeWithDepartment method of EmployeeService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Employee employee = employeeRepo.findByEmployeeId(employeeId);


        Departemnt departemnt = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + employee.getDepartmentId()
                ,Departemnt.class);

//        DEPARTMENT-SERVICE = localhost:9001

        vo.setEmployee(employee);
        vo.setDepartemnt(departemnt);

        return vo;
    }
}
