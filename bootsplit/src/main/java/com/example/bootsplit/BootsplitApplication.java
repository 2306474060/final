package com.example.bootsplit;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.bootsplit"})
@MapperScan("com.example.bootsplit.mapper")
@EnableKnife4j
public class BootsplitApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootsplitApplication.class, args);
    }

}
