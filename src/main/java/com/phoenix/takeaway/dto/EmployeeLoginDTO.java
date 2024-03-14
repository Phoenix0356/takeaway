package com.phoenix.takeaway.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
@Schema(description = "model of employee logging")
public class EmployeeLoginDTO implements Serializable {

    @Schema(description = "username")
    private String username;

    @Schema(description = "password")
    private String password;
}