package com.phoenix.takeaway.service.impl;

import com.phoenix.takeaway.constant.MessageConstant;
import com.phoenix.takeaway.constant.StatusConstant;
import com.phoenix.takeaway.dto.EmployeeLoginDTO;
import com.phoenix.takeaway.entity.Employee;
import com.phoenix.takeaway.exception.PasswordErrorException;
import com.phoenix.takeaway.mapper.EmployeeMapper;
import com.phoenix.takeaway.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.security.auth.login.AccountLockedException;
import javax.security.auth.login.AccountNotFoundException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 员工登录
     *
     * @param employeeLoginDTO
     * @return
     */
    public Employee login(EmployeeLoginDTO employeeLoginDTO) {
        String username = employeeLoginDTO.getUsername();
        String password = employeeLoginDTO.getPassword();

        //1、根据用户名查询数据库中的数据
        Employee employee = employeeMapper.getByUsername(username);

        //2、处理各种异常情况（用户名不存在、密码不对、账号被锁定）
        if (employee == null) {
            //账号不存在
            try {
                throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
            } catch (AccountNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        //密码比对
        // TODO 后期需要进行md5加密，然后再进行比对
        if (!password.equals(employee.getPassword())) {
            //密码错误
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }

        if (employee.getStatus().equals(StatusConstant.DISABLE)) {
            //账号被锁定
            try {
                throw new AccountLockedException(MessageConstant.ACCOUNT_LOCKED);
            } catch (AccountLockedException e) {
                throw new RuntimeException(e);
            }
        }

        //3、返回实体对象
        return employee;
    }

}
