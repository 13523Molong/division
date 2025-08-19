package com.example.demo.service;

import com.example.demo.mapper.WorkMapper;
import com.example.demo.pojo.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkServiceImpl implements WorkService{

    @Autowired
    private WorkMapper workMapper;

    @Override
    public void add(Work work) {
        workMapper.add(work);
    }
}
