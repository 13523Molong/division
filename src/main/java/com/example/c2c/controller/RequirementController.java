package com.example.c2c.controller;

import com.example.c2c.entity.Requirement;
import com.example.c2c.service.RequirementService;
import com.example.c2c.util.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/requirement")
@CrossOrigin(origins = "http://localhost:5173")

public class RequirementController {
@Resource private RequirementService requirementService;
@PostMapping("/publish")
    public Result publishRequirement( @RequestBody Requirement requirement){
    return requirementService.publishRequirement(requirement);
}
}
