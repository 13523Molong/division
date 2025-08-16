package com.example.lc.demo.service.impl;

import com.example.lc.demo.mapper.SelectMapper;
import com.example.lc.demo.pojo.User;
import com.example.lc.demo.pojo.Work;
import com.example.lc.demo.service.SelectService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class SelectServiceImpl implements SelectService
{
    @Autowired
    private SelectMapper selectMapper;
    @Override
    public List<User> getAllUsers()
    {
        return selectMapper.getAllUsers();
    }
    @Override
    public List<Work> page(int page, int pageSize)
    {
        int total=  selectMapper.count();
        int start=(page-1)*pageSize;
        return selectMapper.page(start,pageSize);
    }
}
