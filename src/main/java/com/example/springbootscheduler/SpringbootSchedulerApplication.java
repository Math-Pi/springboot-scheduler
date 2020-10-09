package com.example.springbootscheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//在启动类上面加上@EnableScheduling即可开启定时
@EnableScheduling
public class SpringbootSchedulerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSchedulerApplication.class, args);
    }

}
