package com.xtkj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xtkj.dao.UserMapper;
import com.xtkj.pojo.TUser;
import com.xtkj.service.IUserService;
import com.xtkj.utils.JsonResult;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@DefaultProperties(
        defaultFallback = "getError",
        commandProperties = {
                @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000"),
                @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
                @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "20"),
                @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
                @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
        }
)
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, TUser> implements IUserService {


    @HystrixCommand(fallbackMethod = "userListErrorMsg",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
            })
    @Override
    public List<TUser> allUser() {
        try {
            //线程睡眠
            Thread.sleep(1000);
            int a=10/0;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return list();
    }

    public List<TUser> userListErrorMsg(Throwable throwable) {
        List<TUser> list = new ArrayList<>();
        TUser user = new TUser();
        user.setUserName("局部拦截：请求超时   服务降级///异常服务降级" + throwable.getMessage());
        list.add(user);
        return list;
    }


    @HystrixCommand(fallbackMethod = "getUserByIdError",
            ignoreExceptions = {
//                    NullPointerException.class,
                    ClassNotFoundException.class
            },
            commandProperties = {
                    @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "20"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
            })
    @Override
    public JsonResult getUserById(Integer id) {
        Date date = null;
        date.getTime();
        TUser user = getById(id);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(500);
        jsonResult.setMsg("ok");
        jsonResult.setT(user);

        return jsonResult;
    }

    public JsonResult getUserByIdError(Integer id, Throwable throwable) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(500);
        jsonResult.setMsg("请求超时   服务降级///异常服务降级" + throwable.getMessage());
        return jsonResult;
    }


    @HystrixCommand
    @Override
    public JsonResult getUserByName(String name) {
//        int i = 10/0;
        QueryWrapper<TUser> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", name);
        TUser user = getOne(wrapper);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(200);
        jsonResult.setMsg("ok");
        jsonResult.setT(user);
        return jsonResult;
    }

    public JsonResult getError(Throwable throwable) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(500);
        jsonResult.setMsg("全局拦截：请求超时   服务降级///异常服务降级" + throwable.getMessage());
        return jsonResult;
    }
}
