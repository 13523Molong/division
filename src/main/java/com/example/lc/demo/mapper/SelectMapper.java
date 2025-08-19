package com.example.lc.demo.mapper;

import com.example.lc.demo.pojo.User;
import com.example.lc.demo.pojo.Work;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface SelectMapper
{
    @Select("select * from users ")
    public List<User> getAllUsers();
    
    @Select("select * from works limit #{start},#{pageSize}")
    public List<Work> page(int start, int pageSize);
    
    @Select("select count(*) from works")
    public int count();
}
