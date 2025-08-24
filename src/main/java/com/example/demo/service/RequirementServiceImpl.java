package com.example.demo.service;

import com.example.demo.mapper.RequirementMapper;
import com.example.demo.pojo.Requirement;
import com.example.demo.pojo.RequirementStatus;
import com.example.demo.pojo.response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RequirementServiceImpl implements RequirementService {

    @Autowired
    private RequirementMapper requirementMapper;

    @Override
    public Requirement findById(Integer id) {
        return requirementMapper.findById(id);
    }

    @Override
    public void update(Requirement requirement) {
        requirementMapper.update(requirement);
    }

    @Override
    public Requirement detail(Integer id) {
        Requirement requirement= requirementMapper.detail(id);
        return requirement;
    }


    @Override
    @Transactional
    public response completePhase1(Integer id) {
        Requirement requirement=findById(id);
        if(requirement.getStatus().getDescription().equals("草稿")){//只有status是草稿才能设置为PHASE1，其余两种状态都不可以
            requirementMapper.setPhase1(id, RequirementStatus.PHASE1);
            return response.success();
        }
        return response.error("只有草稿的需求才可以标记为阶段一");
    }

    @Override
    @Transactional
    public response completePhase2(Integer id) {
        Requirement requirement=findById(id);
        if(requirement.getStatus().getDescription().equals("阶段一")){//只有status是草稿才能设置为PHASE1，其余两种状态都不可以
            requirementMapper.setPhase2(id, RequirementStatus.PHASE2);
            return response.success();
        }
        return response.error("只有阶段一的需求才可以标记为阶段二");
    }

    @Override
    public void delete(Integer id) {
        requirementMapper.delete(id);
    }

    @Override
    public void add(Requirement requirement){
        requirementMapper.add(requirement);
    }

    @Override
    public void updateState(String state,Integer id) {
        requirementMapper.updateState(state,id);
    }

    @Override
    public response acceptRequire(Integer id, Integer acceptUser) {

        Requirement requirement=findById(id);
        if(requirement.getState().equals("已发布")){//只有state是已发布才能被接单，其余两种状态都不可以
            requirementMapper.acceptRequire(id,acceptUser,"进行中");
            return response.success();
        }
        else if(requirement.getState().equals("进行中")) {
            return response.error("需求已被接单");
        }
        else{
            return response.error("需求已经完成");
        }
    }
}
