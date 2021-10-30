package com.microservicers.departmentservice.service;

import com.microservicers.departmentservice.entity.Department;
import com.microservicers.departmentservice.repository.DepartmentRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;


    public Department saveDepartment(Department department) {
        log.info("inside save department method of DepartmentService");
       return departmentRepo.save(department);
    }

    public Department findDepartmentById(Long departmentId) {
        return departmentRepo.findByDepartmentId(departmentId);
    }
}
