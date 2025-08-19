package com.example.demo.mapper;

import com.example.demo.pojo.Work;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WorkMapper {
    @Insert("insert into work(title, content,cover_img,state,create_user,create_time)" +
            " values(#{title},#{content},#{coverImg},#{state},#{createUser},now()")
    void add(Work work);
}
