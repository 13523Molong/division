package com.example.lc.demo.service;

import com.example.lc.demo.pojo.Result;
import com.example.lc.demo.pojo.User;

public interface LoginService
{
    public Result login(User user);
    public Result register(User user);
}
