package com.example.demo.service;

import com.example.demo.mapper.RequirementMapper;
import com.example.demo.pojo.Requirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequirementServiceImpl implements RequirementService {

    @Autowired
    private RequirementMapper requirementMapper;

    @Override
    public void add(Requirement requirement){
        requirementMapper.add(requirement);
    }
}
