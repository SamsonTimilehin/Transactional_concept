package com.practice.Spring.Transactional.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequestVO {

    private String empName;
    private String email;
    private String departmentName;
    private String departmentCode;
}
