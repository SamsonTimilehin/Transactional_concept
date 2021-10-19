package com.practice.Spring.Transactional.service;

import com.practice.Spring.Transactional.entity.Department;
import com.practice.Spring.Transactional.entity.Employee;
import com.practice.Spring.Transactional.repository.DepartmentRepository;
import com.practice.Spring.Transactional.repository.EmployeeRepository;
import com.practice.Spring.Transactional.vo.EmployeeRequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional
    //@Transactional in case the department or employee object is null or failed.
    public String saveEmployee(EmployeeRequestVO employeeRequestVO) {
        Department department = new Department();
        department.setDepartmentName(employeeRequestVO.getDepartmentName());
        department.setDepartmentCode(employeeRequestVO.getDepartmentCode());

        Long departmentId = departmentRepository.save(department).getDepartmentId();

        Employee employee = new Employee();
        employee.setEmpName(employeeRequestVO.getEmpName());
        employee.setEmail(employeeRequestVO.getEmail());
        employee.setDepartmentId(departmentId);

        employeeRepository.save(employee);

        return "Employee is saved with Employee ID : " + employee.getEmployeeId();
    }
}
