package com.example.demo.controller;

import com.example.demo.anno.State;
import com.example.demo.pojo.Requirement;
import com.example.demo.pojo.response;
import com.example.demo.service.RequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/requirement")
public class RequirementController {

    @Autowired
    private RequirementService requirementService;

    //发布需求
    @PostMapping("/add")
    public response add(@RequestBody @Validated Requirement requirement){
        requirementService.add(requirement);
        return response.success();
    }

    //更新state，state只能是已发布 进行中，已完成
    @PatchMapping("/updateState")
    public response updateState(@RequestParam @State String state, @RequestParam Integer id){
        requirementService.updateState(state,id);
        return response.success();
    }

    //接单
    @PatchMapping("/accept")
    public response acceptRequirement(@RequestParam Integer id , @RequestParam Integer acceptUser){
        response result=requirementService.acceptRequire(id,acceptUser);
        return result;
    }

    //获取需求详细信息
    @GetMapping("/detail")
    public response<Requirement> detail(@RequestParam Integer id ){
        Requirement requirement=requirementService.detail(id);
        return response.success(requirement);
    }

    //删除需求
    @DeleteMapping("/delete")
    public response delete(@RequestParam Integer id ){
        requirementService.delete(id);
        return response.success();
    }
    //更新需求
    @PutMapping("/update")
    public response updateRequirement(@RequestBody Requirement requirement){
        requirementService.update(requirement);
        return response.success();
    }

    //设置status为阶段一
    @PatchMapping ("/{id}/phase1_complete")
    public response completePhase1(@PathVariable Integer id) {
        response s = requirementService.completePhase1(id);
        return s;
    }

    //设置status为阶段二
    @PatchMapping ("/{id}/phase2_complete")
    public response completePhase2(@PathVariable Integer id) {
        response s = requirementService.completePhase2(id);
        return s;
    }
}
