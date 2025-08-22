package com.example.c2c.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.c2c.entity.Work;
import com.example.c2c.util.Result;
import org.springframework.stereotype.Service;

@Service

public interface WorkService {
    // 分页查询作品列表
    Result getWorkPage(int pageNum, int pageSize);
    Result getWorkById(Long id);
}
