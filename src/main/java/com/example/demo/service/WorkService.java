package com.example.demo.service;

import com.example.demo.pojo.Work;
import com.github.pagehelper.Page;

public interface WorkService {
    Work findById(Integer id);

    void add(Work work);

    Page<Work> list(String title, Integer pageNum, Integer pageSize);

    void delete(Integer id);

    Work detail(Integer id);

    void update(Work work);


}
