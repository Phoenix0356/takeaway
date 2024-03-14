package com.phoenix.takeaway.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
@Data
@Schema(description = "model of adding an employee")
public class EmployeeRegisterDTO implements Serializable {

    private Long id;

    private String username;

    private String name;

    private String phone;

    private String sex;

    private String idNumber;

}
