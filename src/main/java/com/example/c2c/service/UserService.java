package com.example.c2c.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.c2c.entity.User;

import javax.xml.transform.Result;

public interface UserService extends IService<User>  {
    // 用户注册
    Result register(String username, String password);

    // 用户登录
    Result login(String username, String password);
}
