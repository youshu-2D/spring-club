package com.xtkj.controller;

import com.xtkj.pojo.TUser;
import com.xtkj.service.IUserServcie;
import com.xtkj.utils.JsonResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {

    @Resource
    private IUserServcie userServcie;

    @RequestMapping("/consumer/getPort")
    public String getPort(){
        return userServcie.getPort();
    }

    @RequestMapping("/consumer/allUsers")
    public List<TUser> getUsers(){
        return userServcie.allUser();
    }

    @RequestMapping("/consumer/listUser")
    public List<TUser> listUser(){
//        int a=10/0;
        return userServcie.listUser();
    }

    @RequestMapping("/consumer/getUserById/{id}")
    public JsonResult getUserById(@PathVariable Integer id) {
//        int a=10/0;
        return userServcie.getUserById(id);
    }
}
