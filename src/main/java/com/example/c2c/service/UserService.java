package com.example.c2c.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.c2c.entity.User;
import com.example.c2c.util.Result;



public interface UserService extends IService<User>  {
    // 用户注册
    Result register(User user);

    // 用户登录
    Result login(User user);
}
