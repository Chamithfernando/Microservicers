package com.microservicers.employeeservice.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Departemnt {

    private Long departmentId;
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
}
