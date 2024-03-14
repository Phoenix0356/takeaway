package com.phoenix.takeaway.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 后端统一返回结果
 * @param <T>
 */
@Data
public class ResultVO<T> implements Serializable {

    private Integer code; //编码：1成功，0和其它数字为失败
    private String msg; //错误信息
    private T data; //数据

    public static <T> ResultVO<T> success() {
       ResultVO<T> resultVO = new ResultVO<T>();
       resultVO.code = 1;
       return resultVO;
    }

    public static <T> ResultVO<T> success(T object) {
        ResultVO<T> resultVO = new ResultVO<T>();
        resultVO.data = object;
        resultVO.code = 1;
        return resultVO;
    }

    public static <T> ResultVO<T> error(String msg) {
        ResultVO<T> resultVO = new ResultVO<T>();
        resultVO.msg = msg;
        resultVO.code = 0;
        return resultVO;
    }

}