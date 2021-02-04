package com.task.regions;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.task.regions.mapper")
@EnableCaching
public class DirectoryOfRegionsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DirectoryOfRegionsApplication.class, args);
    }

}
