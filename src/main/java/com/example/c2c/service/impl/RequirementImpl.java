package com.example.c2c.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.c2c.entity.Requirement;
import com.example.c2c.mapper.RequirementMapper;
import com.example.c2c.service.RequirementService;
import com.example.c2c.util.Result;
import org.springframework.stereotype.Service;

@Service
public class RequirementImpl extends ServiceImpl<RequirementMapper, Requirement> implements RequirementService {
@Override
    public Result publishRequirement(Requirement requirement) {
//1.检验非空
    if (requirement.getTitle() == null || requirement.getTitle().trim().isEmpty()) {
        return Result.fail("标题不能为空");
    }
    if (requirement.getContent() == null || requirement.getContent().trim().isEmpty()) {
        return Result.fail("内容不能为空");
    }
    if (requirement.getUserId() == null) {
        return Result.fail("用户ID不能为空");
    }

    //2.保存数据
    boolean success = this.save(requirement);
    if (success) {
        return Result.success("发布成功", requirement.getId()); // 返回新需求的ID
    } else {
        return Result.fail("发布失败");
    }
}
}
