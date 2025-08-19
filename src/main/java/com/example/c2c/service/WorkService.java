package com.example.c2c.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.c2c.entity.Work;

public interface WorkService {
    // 分页查询作品列表
    IPage<Work> getWorkPage(int pageNum, int pageSize);
}
