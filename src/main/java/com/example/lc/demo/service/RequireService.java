package com.example.lc.demo.service;

import com.example.lc.demo.pojo.Requirement;
import com.example.lc.demo.pojo.Result;

public interface RequireService
{
    public Result createRequirement(Requirement requirement);
    
    public Result acceptRequirement(int id, int acceptorId);
    public Result completeRequirement(int id, int completerId);
    public Result updatePhase(int id, int userId);
}
