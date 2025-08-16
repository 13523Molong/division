package com.example.lc.demo.controller;

import com.example.lc.demo.pojo.Requirement;
import com.example.lc.demo.pojo.Result;
import com.example.lc.demo.service.RequireService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Slf4j
@RestController
public class RequireController
{
    
    @Autowired
    private RequireService requireService;
    
    @PostMapping("/createRequirement")
    public Result createRequirement(@RequestBody Requirement requirement)
    {
        log.info("创建需求");
        return requireService.createRequirement(requirement);
    }
    
    @PostMapping("/acceptRequirement")
    public Result acceptRequirement(int  id, int  acceptorId)
    {
        log.info("接取需求");
        return requireService.acceptRequirement( id,  acceptorId);
    }
    
    @PostMapping("/completeRequirement")
    public Result completeRequirement(int  id, int  completerId)
    {
        log.info("完成需求");
        return requireService.completeRequirement( id,  completerId);
    }
    
    @PostMapping("/updatePhase")
    public Result updatePhase(int  id, int  userId)
    {
        log.info("更新需求阶段");
        return requireService.updatePhase( id,  userId);
    }
    
    
}
