package com.example.demo.controller;

import com.example.demo.pojo.Requirement;
import com.example.demo.pojo.response;
import com.example.demo.service.RequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/requirement")
public class RequirementController {

    @Autowired
    private RequirementService requirementService;

    @PostMapping
    public response add(@RequestBody @Validated Requirement requirement){
        requirementService.add(requirement);
        return response.success();
    }



}
