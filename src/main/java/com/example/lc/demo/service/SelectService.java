package com.example.lc.demo.service;

import com.example.lc.demo.pojo.Result;
import com.example.lc.demo.pojo.User;
import com.example.lc.demo.pojo.Work;

import java.util.List;

public interface SelectService
{
    public List<User> getAllUsers();
    public List<Work> page(int page,int pageSize);
    
}
