package com.phoenix.takeaway.service;


import com.phoenix.takeaway.dto.EmployeeLoginDTO;
import com.phoenix.takeaway.dto.EmployeeRegisterDTO;
import com.phoenix.takeaway.entity.Employee;
import com.phoenix.takeaway.exception.UsernameExistException;

import javax.security.auth.login.AccountLockedException;
import javax.security.auth.login.AccountNotFoundException;
import java.sql.SQLIntegrityConstraintViolationException;

public interface EmployeeService {

    /**
     * 员工登录
     * @param employeeLoginDTO
     * @return
     */
    Employee login(EmployeeLoginDTO employeeLoginDTO) throws AccountNotFoundException, AccountLockedException;
    void save(EmployeeRegisterDTO employeeRegisterDTO) throws SQLIntegrityConstraintViolationException, UsernameExistException;
}