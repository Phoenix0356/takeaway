package com.phoenix.takeaway;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@SpringBootApplication
@EnableTransactionManagement
public class TakeawayApplication {

    public static void main(String[] args) {
        SpringApplication.run(TakeawayApplication.class, args);
        log.info("project on run successfully");
    }

}
