package com.xtkj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xtkj.pojo.TUser;
import com.xtkj.utils.JsonResult;

import java.util.List;


public interface IUserService extends IService<TUser> {
    List<TUser> allUser();
    JsonResult getUserById(Integer id);
    JsonResult getUserByName(String name);
}
