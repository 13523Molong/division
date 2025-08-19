package com.example.demo.mapper;

import com.example.demo.pojo.Requirement;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RequirementMapper {

    @Insert("insert into requirement(requirement_name,content,state,create_user,create_time)" +
            " values(#{requirementName},#{content},#{state},#{createUser},now())")
    void add(Requirement requirement);

}
