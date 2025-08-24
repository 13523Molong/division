package com.example.demo.mapper;

import com.example.demo.pojo.Work;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface WorkMapper {
    @Insert("insert into work(title,content,create_user,create_time,update_time)" +
            " values(#{title},#{content},#{createUser},now(),now())")
    void add(Work work);

    @Select("select * from work where title=#{title}")
    List<Work> list(String title);

    @Delete("delete from work where id=#{id}")
    void delete(Integer id);

    @Select("select * from work where id=#{id}")
    Work detail(Integer id);

    @Update("update work set title=#{title},content=#{content},create_user=#{createUser},update_time=now() " +
            "where id=#{id}")
    void update(Work work);

    @Select("select * from work where id=#{id}")
    Work findById(Integer id);
}
