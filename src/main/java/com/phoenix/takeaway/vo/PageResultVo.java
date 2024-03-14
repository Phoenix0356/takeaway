package com.phoenix.takeaway.vo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class PageResultVo {
    private long total;
    private List<?> records;
}
