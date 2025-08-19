package com.example.lc.demo.controller;

import com.example.lc.demo.pojo.Result;
import com.example.lc.demo.pojo.User;
import com.example.lc.demo.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController
{
    @Autowired
    private LoginService loginService;
    
    @PostMapping("/register")
    public Result register(@RequestBody User user)
    {
        log.info("用户{}注册", user.getUsername());
        return loginService.register(user);
    }
    
    @PostMapping("/login")
    public Result login(@RequestBody User user)
    {
        log.info("用户登录");
        return loginService.login(user);
        
    }
}
