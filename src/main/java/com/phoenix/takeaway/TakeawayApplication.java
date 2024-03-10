package com.phoenix.takeaway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@Slf4j
@SpringBootApplication
public class TakeawayApplication {

    public static void main(String[] args) {
        SpringApplication.run(TakeawayApplication.class, args);
        log.info("project on run successfully");
    }

}
