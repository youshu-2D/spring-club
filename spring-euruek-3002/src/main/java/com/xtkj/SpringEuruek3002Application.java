package com.xtkj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringEuruek3002Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringEuruek3002Application.class, args);
    }

}
