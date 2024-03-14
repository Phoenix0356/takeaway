package com.phoenix.takeaway.service.impl;

import com.phoenix.takeaway.constant.MessageConstant;
import com.phoenix.takeaway.constant.StatusConstant;
import com.phoenix.takeaway.context.ThreadContext;
import com.phoenix.takeaway.dto.EmployeeLoginDTO;
import com.phoenix.takeaway.dto.EmployeeRegisterDTO;
import com.phoenix.takeaway.entity.Employee;
import com.phoenix.takeaway.exception.AccountLockedException;
import com.phoenix.takeaway.exception.AccountNotFoundException;
import com.phoenix.takeaway.exception.PasswordErrorException;
import com.phoenix.takeaway.exception.UsernameExistException;
import com.phoenix.takeaway.mapper.EmployeeMapper;
import com.phoenix.takeaway.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;

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
    public Employee login(EmployeeLoginDTO employeeLoginDTO) throws AccountNotFoundException, AccountLockedException {
        String username = employeeLoginDTO.getUsername();
        String password = employeeLoginDTO.getPassword();

        //1、根据用户名查询数据库中的数据
        Employee employee = employeeMapper.getByUsername(username);


        //2、处理各种异常情况（用户名不存在、密码不对、账号被锁定）
        if (employee == null) {
            //账号不存在
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);

        }

        //密码比对
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!password.equals(employee.getPassword())) {
            //密码错误
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }

        if (employee.getStatus().equals(StatusConstant.DISABLE)) {
            //账号被锁定
            throw new AccountLockedException(MessageConstant.ACCOUNT_LOCKED);

        }

        //3、返回实体对象
        return employee;
    }

    public void save(EmployeeRegisterDTO employeeRegisterDTO) throws SQLIntegrityConstraintViolationException, UsernameExistException {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeRegisterDTO,employee);

        employee.setStatus(StatusConstant.ENABLE);

        employee.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));

        employee.setCreateTime(LocalDateTime.now());
        employee.setUpdateTime(LocalDateTime.now());

        //ToDo
        employee.setCreateUser(ThreadContext.getCurrentId());
        employee.setUpdateUser(ThreadContext.getCurrentId());

        try {
            employeeMapper.insert(employee);
        }catch (Exception e){
            throw new UsernameExistException(employee.getUsername()+MessageConstant.ALREADY_EXIST);
        }





    }

}
