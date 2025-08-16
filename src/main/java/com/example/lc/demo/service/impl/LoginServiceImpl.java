package com.example.lc.demo.service.impl;

import com.example.lc.demo.mapper.LoginMapper;
import com.example.lc.demo.pojo.Result;
import com.example.lc.demo.pojo.User;
import com.example.lc.demo.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Slf4j
@Service
public class LoginServiceImpl implements LoginService
{
    @Autowired
    private LoginMapper loginMapper;
    @Override
    public Result login(User user)
    {
        if (loginMapper.select(user) != null) {
            log.info("用户登录成功");
            return Result.success();
        } else {
            log.info("用户登录失败");
            return Result.error("账号或密码错误");
        }
    }
    
    @Override
    public Result register(User user) {
        
            // 检查用户名是否存在
            if(loginMapper.existByUsername(user.getUsername())) {
                log.info("用户已存在");
                return Result.error("用户已存在");
            }
            
            // 设置创建时间
            user.setCreatedTime(LocalDateTime.now());
            
            // 执行插入并检查结果
            int affectedRows = loginMapper.insert(user);
            if(affectedRows != 1) {
                log.error("插入数据失败");
                throw new RuntimeException("插入数据失败");
            }
            
            // 验证插入是否成功
            User insertedUser = loginMapper.select(user);
            if(insertedUser == null) {
                log.error("数据未正确插入");
                throw new RuntimeException("数据未正确插入");
            }
            log.info("用户注册成功");
            
            return Result.success();
        
    }
}
