package com.example.c2c.controller;

import com.example.c2c.entity.User;
import com.example.c2c.service.UserService;
import com.example.c2c.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/user/register")
    public Result register(@RequestBody User user){
        System.out.println("接收的用户名：" + user.getUsername());
        System.out.println("接收的密码：" + user.getPassword());




        return userService.register(user);
    }
    }




