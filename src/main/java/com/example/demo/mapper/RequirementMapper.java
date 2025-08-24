package com.example.demo.mapper;

import com.example.demo.pojo.Requirement;
import com.example.demo.pojo.RequirementStatus;
import org.apache.ibatis.annotations.*;

@Mapper
public interface RequirementMapper {

    @Select("select * from requirement where id=#{id}")
    Requirement findById(Integer id);

    @Insert("insert into requirement(title,content,create_user,create_time,update_time)" +
            " values(#{title},#{content},#{createUser},now(),now())")
    void add(Requirement requirement);

    @Update("update requirement set accept_user=#{acceptUser},state=#{state},update_time=now() " +
            "where id=#{id}")
    void acceptRequire(Integer id, Integer acceptUser,String state);

    @Update("update requirement set state=#{state},update_time=now() " +
            "where id=#{id}")
    void updateState(String state, Integer id);

    @Update("update requirement set title=#{title},content=#{content},create_user=#{createUser},state=#{state},update_time=now() " +
            "where id=#{id}")
    void update(Requirement requirement);

    @Select("select * from requirement where id=#{id}")
    Requirement detail(Integer id);

    @Update("update requirement set status=#{status},update_time=now() " +
            "where id=#{id}")
    void setPhase1(Integer id, RequirementStatus status);

    @Update("update requirement set status=#{status},update_time=now() " +
            "where id=#{id}")
    void setPhase2(Integer id, RequirementStatus status);

    @Delete("delete from requirement where id=#{id}")
    void delete(Integer id);
}
