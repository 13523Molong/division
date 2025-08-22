package com.example.c2c.controller;

import com.example.c2c.service.WorkService;
import com.example.c2c.util.Result;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class WorkController {
private final WorkService workService;

    public WorkController(WorkService workService) {
        this.workService = workService;
    }
    @GetMapping("/work/list")
    public Result getWorkPage(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize) {


        return workService.getWorkPage(pageNum, pageSize);
    }
    @GetMapping("/work/detail")
    public Result getWorkById(Long id) {
        return workService.getWorkById(id);
    }
}
