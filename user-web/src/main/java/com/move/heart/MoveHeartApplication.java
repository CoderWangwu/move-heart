package com.move.heart;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@MapperScan("com.move.heart.dao")
@EnableConfigurationProperties
public class MoveHeartApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoveHeartApplication.class, args);
    }

}
