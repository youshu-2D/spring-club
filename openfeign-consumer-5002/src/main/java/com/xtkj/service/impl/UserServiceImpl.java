package com.xtkj.service.impl;

import com.xtkj.pojo.TUser;
import com.xtkj.service.IUserServcie;
import com.xtkj.utils.JsonResult;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements IUserServcie {
    @Override
    public String getPort() {
        return "0000";
    }

    @Override
    public List<TUser> allUser() {
        List<TUser> users = new ArrayList<>();
        TUser use = new TUser();
        use.setUserName("熔断 或者降级 ====》");
        users.add(use);
        return users;
    }

    @Override
    public List<TUser> listUser() {
        return null;
    }

    @Override
    public JsonResult getUserById(Integer id) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(500);
        jsonResult.setMsg("请求超时   熔断///异常服务降级" );
        return jsonResult;
    }

}
