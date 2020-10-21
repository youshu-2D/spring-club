package com.xtkj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@MapperScan("com.xtkj.dao")
public class SpringProducer4001Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringProducer4001Application.class, args);
    }

}
