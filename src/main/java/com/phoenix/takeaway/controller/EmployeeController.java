package com.phoenix.takeaway.controller;


import com.phoenix.takeaway.config.JwtConfig;
import com.phoenix.takeaway.constant.JwtClaimsConstant;
import com.phoenix.takeaway.dto.EmployeeRegisterDTO;
import com.phoenix.takeaway.entity.Employee;
import com.phoenix.takeaway.exception.UsernameExistException;
import com.phoenix.takeaway.service.EmployeeService;
import com.phoenix.takeaway.dto.EmployeeLoginDTO;
import com.phoenix.takeaway.util.JwtUtil;
import com.phoenix.takeaway.vo.EmployeeLoginVO;
import com.phoenix.takeaway.vo.PageResultVo;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.phoenix.takeaway.vo.ResultVO;

import javax.security.auth.login.AccountLockedException;
import javax.security.auth.login.AccountNotFoundException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

/**
 * 员工管理
 */
@RestController
@RequestMapping("/admin/employee")
@Tag(name = "员工接口")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private JwtConfig jwtConfig;

    /**
     * 登录
     *
     * @param employeeLoginDTO
     * @return
     */
    @PostMapping("/login")
    @Operation(summary = "登录")
    public ResultVO<EmployeeLoginVO> login(@RequestBody EmployeeLoginDTO employeeLoginDTO) throws AccountLockedException, AccountNotFoundException {
        log.info("员工登录：{}", employeeLoginDTO);

        Employee employee = employeeService.login(employeeLoginDTO);

        //登录成功后，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.EMP_ID, employee.getId());
        String token = JwtUtil.createJWT(
                jwtConfig.getAdminSecretKey(),
                jwtConfig.getAdminTtl(),
                claims);

        EmployeeLoginVO employeeLoginVO = EmployeeLoginVO.builder()
                .id(employee.getId())
                .userName(employee.getUsername())
                .name(employee.getName())
                .token(token)
                .build();

        return ResultVO.success(employeeLoginVO);
    }

    /**
     * 退出
     *
     * @return
     */
    @PostMapping("/logout")
    public ResultVO<String> logout() {
        return ResultVO.success();
    }

    @PostMapping("/save")
    @Operation(summary = "save employee")
    public ResultVO save(@RequestBody EmployeeRegisterDTO employeeRegisterDTO) throws UsernameExistException, SQLIntegrityConstraintViolationException {
        log.info("add new employee");
        employeeService.save(employeeRegisterDTO);
        return ResultVO.success();
    }

    @GetMapping("/query")
    @Operation(summary =  "query employee")
    public ResultVO<PageResultVo> query(PageResultVo pageResultVo){
        log.info("员工分页查询： "+ pageResultVo);
        return null;
    }

}
