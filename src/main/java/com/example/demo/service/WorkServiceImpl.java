package com.example.demo.service;

import com.example.demo.mapper.WorkMapper;
import com.example.demo.pojo.Work;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkServiceImpl implements WorkService{

    @Autowired
    private WorkMapper workMapper;

    @Override
    public Work findById(Integer id) {
        return workMapper.findById(id);
    }

    @Override
    public void add(Work work) {
        workMapper.add(work);
    }

    @Override
    public Page<Work> list(String title, Integer pageNum, Integer pageSize) {

        //分页
        PageHelper.startPage(pageNum, pageSize);//在当前线程中设置分页参数，后续执行的第一个 MyBatis 查询会自动进行物理分页
        //原理：通过 MyBatis 拦截器在 SQL 执行前自动添加分页语句

        //返回所有标题为查询标题的作品
        Page<Work> page =  (Page<Work>) workMapper.list(title);
        return page;

    }

    @Override
    public void delete(Integer id) {
        workMapper.delete(id);
    }

    @Override
    public Work detail(Integer id) {
        Work work=workMapper.detail(id);
        return work;
    }

    @Override
    public void update(Work work) {
        workMapper.update(work);
    }
}
