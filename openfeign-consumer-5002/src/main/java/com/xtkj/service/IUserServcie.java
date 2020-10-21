package com.xtkj.service;

import com.xtkj.pojo.TUser;
import com.xtkj.service.impl.UserServiceImpl;
import com.xtkj.utils.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "SPRING-PRODUCER-4001",fallback = UserServiceImpl.class)
public interface IUserServcie {
    @RequestMapping("/producer/getPort")
    String getPort();
    @RequestMapping("/producer/allUser")
    List<TUser> allUser();
    @RequestMapping("/producer/listUser")
    List<TUser> listUser();
    @RequestMapping("/producer/getUserById/{id}")
    JsonResult getUserById(@PathVariable Integer id);
//    @RequestMapping("/producer/getUserByName/{name}")
//    JsonResult getUserByName(String name);
}
