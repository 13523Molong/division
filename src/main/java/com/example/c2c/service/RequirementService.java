package com.example.c2c.service;

import com.example.c2c.entity.Requirement;
import com.example.c2c.util.Result;


public interface RequirementService {
    //发布需求
    Result publishRequirement(Requirement  requirement);
}
