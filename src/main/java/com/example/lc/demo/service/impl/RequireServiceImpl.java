package com.example.lc.demo.service.impl;

import com.example.lc.demo.mapper.RequireMapper;
import com.example.lc.demo.pojo.Requirement;
import com.example.lc.demo.pojo.Result;
import com.example.lc.demo.service.RequireService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Slf4j
@Service
public class RequireServiceImpl implements RequireService
{
    @Autowired
    private RequireMapper requireMapper;
    @Override
    public Result createRequirement(Requirement requirement)
    {
        if(!requireMapper.userExisted(requirement.getPublisherId()))
        {
            log.warn("用户不存在: {}", requirement.getPublisherId());
            return Result.error("用户不存在");
        }
        int result = requireMapper.insert(requirement);
        if(result==1) {
            log.info("创建成功");
            return Result.success();
          
        }
        log.error("创建失败");
        return Result.error("创建失败");
        
    }
    
    @Override
    @Transactional
    public Result acceptRequirement(int id, int acceptorId) {
        
            Requirement requirement = requireMapper.selectById(id);
            if (requirement == null) {
                log.warn("需求不存在: {}", id);
                return Result.error("需求不存在");
            }
            
            if (!requirement.getStatus().equals("PUBLISHED")) {
                log.warn("需求[{}]当前状态不可接单: {}", id, requirement.getStatus());
                return Result.error("当前状态不可接单");
            }
            
            if (!requireMapper.userExisted(acceptorId)) {
                log.warn("接单用户不存在: {}", acceptorId);
                return Result.error("用户不存在");
            }
            
            requirement.setStatus("IN_PROGRESS");
            requirement.setAcceptorId(acceptorId);
            requirement.setUpdateTime(LocalDateTime.now());
            
            int updated = requireMapper.acceptRequirement(requirement);
            if (updated == 0) {
                log.warn("接单失败: id={}", id);
                return Result.error("接单失败");
            }
            
            return Result.success(requirement);
        
    
    }
    @Override
    public Result completeRequirement(int id, int completerId)
    {
        // 1. 检查需求是否存在
        Requirement requirement = requireMapper.selectById(id);
        if (requirement == null) {
            log.warn("需求不存在: {}", id);
            return Result.error("需求不存在");
        }
        
        // 2. 验证需求是否已被接取
        if (requirement.getAcceptorId() == null) {
            log.warn("需求[{}]尚未被接取，无法完成", id);
            return Result.error("需求尚未被接取");
        }
        
        // 3. 验证接单者是否是当前完成者
        if (!requirement.getAcceptorId().equals(completerId)) {
            log.warn("用户[{}]无权限完成需求[{}]", completerId, id);
            return Result.error("无权限完成该需求");
        }
        
        // 4. 检查需求状态是否可完成
        if (!requirement.getStatus().equals("IN_PROGRESS")) {
            log.warn("需求[{}]当前状态不可完成: {}", id, requirement.getStatus());
            return Result.error("当前状态不可完成");
        }
        
        // 5. 更新需求状态
        requirement.setStatus("COMPLETED");
        requirement.setUpdateTime(LocalDateTime.now());
        
        
        int updated = requireMapper.completeRequirement(requirement);
        if (updated == 0) {
            log.warn("完成需求失败: id={}", id);
            return Result.error("完成需求失败");
        }
        
        log.info("需求完成成功: id={}, completerId={}", id, completerId);
        return Result.success(requirement);
    }
    
    @Override
    public Result updatePhase(int id, int userId)
    {
        Requirement requirement = requireMapper.selectById(id);
        if (requirement == null) {
            log.warn("需求不存在: {}", id);
            return Result.error("需求不存在");
        }
        
        if (!requirement.getStatus().equals("IN_PROGRESS")) {
            log.warn("需求[{}]当前状态不可更新阶段: {}", id, requirement.getStatus());
            return Result.error("当前状态不可更新阶段");
        }
        
        if (!requirement.getAcceptorId().equals(userId)) {
            log.warn("用户[{}]无权限更新需求[{}]阶段", userId, id);
            return Result.error("无权限更新该需求阶段");
        }
        
        if(requirement.getPhase().equals("PHASE_1"))
        {
            requirement.setPhase("PHASE_2");
        }
        else if(requirement.getPhase().equals("PHASE_2"))
        {
            requirement.setStatus("COMPLETED");
        }
        requireMapper.updatePhase(requirement);
        return Result.success(requirement);
    }

}
