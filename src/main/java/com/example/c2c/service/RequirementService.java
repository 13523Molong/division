package com.example.c2c.service;

import javax.xml.transform.Result;

public interface RequirementService {
    //发布需求
    Result publishRequirement(Long userId, String title, String content);
}
