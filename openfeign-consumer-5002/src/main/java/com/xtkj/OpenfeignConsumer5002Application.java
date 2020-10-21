package com.xtkj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OpenfeignConsumer5002Application {

    public static void main(String[] args) {
        SpringApplication.run(OpenfeignConsumer5002Application.class, args);
    }

}
