package com.springbootEvent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * EnableAsync 开启异步处理
 */
@SpringBootApplication
@EnableAsync
public class springbootEvent {
    public static void main(String[] args) {
        SpringApplication.run(springbootEvent.class, args);
    }
}
