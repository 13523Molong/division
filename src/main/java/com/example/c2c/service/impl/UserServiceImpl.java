package com.example.c2c.service.impl;


import com.example.c2c.util.Result;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.c2c.entity.User;
import com.example.c2c.mapper.UserMapper;
import com.example.c2c.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    // 1. 检查用户名是否已存在
    @Override
    public Result register(User user) {
        QueryWrapper<User> queryWrapper=new QueryWrapper();
        queryWrapper.eq("username",user.getUsername());
        User existUser= baseMapper.selectOne(queryWrapper);
        if(existUser!=null){
            return Result.fail("用户名已存在");
        }
        // 2. 创建用户
        user.setCreateTime(LocalDateTime.now());

        baseMapper.insert( user);
        return Result.success("注册成功",user);
    }

    @Override
    public Result login(User user) {
        //1. 检查用户名是否存在
        QueryWrapper<User> queryWrapper=new QueryWrapper();
        queryWrapper.eq("username",user.getUsername());
        User dbUser= baseMapper.selectOne(queryWrapper);
        if(dbUser==null){
            return Result.fail("用户不存在");
        }
        //2. 检查密码是否一致
        if(!dbUser.getPassword().equals(user.getPassword())){
            return Result.fail("密码错误");
        }
        //3. 返回成功结果
        return Result.success("登录成功",dbUser);





    }
}
