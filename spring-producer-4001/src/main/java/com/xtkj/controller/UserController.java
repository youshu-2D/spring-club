package com.xtkj.controller;

import com.xtkj.pojo.TUser;
import com.xtkj.service.IUserService;
import com.xtkj.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private IUserService userService;

    @RequestMapping("/producer/getPort")
    public String getPort(){
        return "spring-producer-4001=============>"+port;
    }

    @RequestMapping("/producer/allUser")
    public List<TUser> allUser(){
        return userService.allUser();
    }
    @RequestMapping("/producer/listUser")
    public List<TUser> listUser(){
        return userService.list();
    }

    @RequestMapping("/producer/getUserById/{id}")
    public JsonResult getUserById(@PathVariable Integer id){
//       int a=10/0;
        return userService.getUserById(id);
    }

    @RequestMapping("/producer/getUserByName/{name}")
    public JsonResult getUserByName(@PathVariable String name){
        return userService.getUserByName(name);
    }
}
