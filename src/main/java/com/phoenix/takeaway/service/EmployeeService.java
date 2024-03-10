package com.phoenix.takeaway.service;


import com.phoenix.takeaway.dto.EmployeeLoginDTO;
import com.phoenix.takeaway.entity.Employee;

public interface EmployeeService {

    /**
     * 员工登录
     * @param employeeLoginDTO
     * @return
     */
    Employee login(EmployeeLoginDTO employeeLoginDTO);

}