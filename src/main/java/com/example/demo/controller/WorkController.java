package com.example.demo.controller;

import com.example.demo.pojo.Requirement;
import com.example.demo.pojo.Work;
import com.example.demo.pojo.response;
import com.example.demo.service.RequirementService;
import com.example.demo.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/work")
public class WorkController {

    @Autowired
    private WorkService workService;

    @PostMapping
    public response add(@RequestBody @Validated Work work){
        workService.add(work);
        return response.success();
    }

}
