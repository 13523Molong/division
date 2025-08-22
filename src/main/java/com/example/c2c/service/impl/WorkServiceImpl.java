package com.example.c2c.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.c2c.entity.Work;
import com.example.c2c.mapper.WorkMapper;
import com.example.c2c.service.WorkService;
import com.example.c2c.util.Result;
import org.springframework.stereotype.Service;

@Service
public class WorkServiceImpl extends ServiceImpl<WorkMapper, Work> implements WorkService {
    @Override
    public Result getWorkPage(int pageNum, int pageSize){
        // 创建分页对象（pageNum：页码，pageSize：每页条数）
        Page<Work> page = new Page<>(pageNum, pageSize);

        // 分页查询（无条件查询所有作品）
        IPage<Work> workPage = baseMapper.selectPage(page, null);

        // 返回分页结果（包含总条数、总页数、当前页数据）
        return Result.success("作品列表查询成功", workPage);





    }
    @Override
    public Result getWorkById(Long id){

        return null;



    }
}
