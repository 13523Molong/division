package com.example.lc.demo.controller;

import com.example.lc.demo.pojo.Result;
import com.example.lc.demo.pojo.User;
import com.example.lc.demo.pojo.Work;
import com.example.lc.demo.service.SelectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Slf4j
@RestController
public class SelectController
{
    @Autowired
    private SelectService selectService;
 @GetMapping("/hello")
    public Result getAllUsers()
    {
        List<User> users = selectService.getAllUsers();
        log.info("查询全部用户");
        return Result.success(users);
    }
    
    @GetMapping("/page")
    public Result page(int page,int pageSize)
    {
        log.info("分页查询"+page+"页"+pageSize+"条数据");
        List<Work> works = selectService.page(page,pageSize);
        return Result.success(works);
    }
}
