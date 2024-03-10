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
       ResultVO<T> resultDTO = new ResultVO<T>();
       resultDTO.code = 1;
        return resultDTO;
    }

    public static <T> ResultVO<T> success(T object) {
        ResultVO<T> resultDTO = new ResultVO<T>();
        resultDTO.data = object;
        resultDTO.code = 1;
        return resultDTO;
    }

    public static <T> ResultVO<T> error(String msg) {
        ResultVO<T> resultDTO = new ResultVO<T>();
        resultDTO.msg = msg;
        resultDTO.code = 0;
        return resultDTO;
    }

}