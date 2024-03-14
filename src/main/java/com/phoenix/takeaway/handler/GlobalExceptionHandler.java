package com.phoenix.takeaway.handler;


import com.phoenix.takeaway.exception.BaseException;
import com.phoenix.takeaway.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

/**
 * 全局异常处理器，处理项目中抛出的业务异常
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 捕获业务异常
     * @param ex
     * @return
     */
    @ExceptionHandler
    public ResultVO<?> exceptionHandler(BaseException ex){
        log.error("异常信息：{}", ex.getMessage());
        return ResultVO.error(ex.getMessage());
    }

    @ExceptionHandler
    public ResultVO<?> sqlExceptionHandler(SQLException sqlException){
        log.error("异常信息：{}", sqlException.getMessage());
        return ResultVO.error(sqlException.getMessage());
    }

}