package com.phoenix.takeaway.dto;

import lombok.Data;

@Data
public class EmployPageQueryDTO {
    private String username;
    private int page;
    private int pageSize;
}
