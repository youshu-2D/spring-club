package com.xtkj.controller;

import com.xtkj.pojo.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/user/getProducerPort")
    public String getProducerPort(){
        return restTemplate.getForObject("http://SPRING-PRODUCER-4001/user/getPort", String.class);
    }

    @RequestMapping("/user/allUser")
    public List<TUser> getUser(){
        return restTemplate.getForObject("http://SPRING-PRODUCER-4001/user/allUser", List.class);
    }
}
