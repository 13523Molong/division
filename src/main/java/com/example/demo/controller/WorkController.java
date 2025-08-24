package com.example.demo.controller;

import com.example.demo.pojo.Work;
import com.example.demo.pojo.response;
import com.example.demo.service.WorkService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/work")
public class WorkController {

    @Autowired
    private WorkService workService;

    //发布作品
    @PostMapping("/add")
    public response add(@RequestBody @Validated Work work){
        workService.add(work);
        return response.success();
    }

    //获取作品列表
    @GetMapping("/list")
    public response<Page<Work>> list(
            @RequestParam String title,//要查询的标题标题
            @RequestParam(defaultValue = "1") Integer pageNum,//分页的数目 如果没提供，默认值为1
            @RequestParam(defaultValue = "10") Integer pageSize) {//每一页的大小，默认值为10

        Page<Work> pb= workService.list(title,pageNum,pageSize);
        return response.success(pb);
    }

    //删除作品
    @DeleteMapping("/delete")
    public response delete(Integer id){

        workService.delete(id);
        return response.success();
    }

    //获得作品详细信息
    @GetMapping("/detail")
    public response<Work> detail(Integer id){
        Work work=workService.detail(id);
        return response.success(work);
    }

    //更新作品
    @PutMapping("/update")
    public response update(@RequestBody Work work){
        workService.update(work);
        return response.success();
    }

}
