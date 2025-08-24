package com.example.demo.service;

import com.example.demo.pojo.Requirement;
import com.example.demo.pojo.response;
import org.hibernate.validator.constraints.URL;

public interface RequirementService {
    void add(Requirement requirement);

    void updateState(String state,Integer id);

    response acceptRequire(Integer id, Integer acceptUser);

    Requirement findById(Integer id);

    void update(Requirement requirement);

    Requirement detail(Integer id);

    response completePhase1(Integer id);

    response completePhase2(Integer id);

    void delete(Integer id);
}
