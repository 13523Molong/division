package com.example.lc.demo.mapper;

import com.example.lc.demo.pojo.Requirement;
import org.apache.ibatis.annotations.*;

@Mapper
public interface RequireMapper
{
    //创建需求
    @Insert("INSERT INTO requirements(title, content, publisher_id, createTime, updateTime, status, phase, acceptor_id) VALUES(#{title}, #{content}, #{publisher_id}, #{createTime}, #{updateTime}, #{status}, #{phase}, #{acceptor_id})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Requirement requirement);
    
    //根据id查询需求
    @Select("SELECT * FROM requirements WHERE id = #{id}")
    Requirement selectById(@Param("id") Integer id);
    
    
    //接受需求
    @Update("UPDATE requirements SET status = 'IN_PROGRESS', acceptor_id = #{acceptor_id}, updateTime = #{updateTime} WHERE id = #{id}")
    int acceptRequirement(Requirement requirement);
    
    //判断用户是否存在
    @Select("SELECT EXISTS(SELECT 1 FROM users WHERE id = #{userId})")
    boolean userExisted(@Param("acceptorId") int userId);
    
    //完成需求
    @Update("UPDATE requirements SET status = 'COMPLETED', updateTime = #{updateTime} WHERE id = #{id}")
    int completeRequirement(Requirement requirement);
    
    //阶段转换
    @Update("UPDATE requirements SET phase = #{phase}, updateTime = #{updateTime} WHERE id = #{id}")
    int updatePhase(Requirement requirement);
    
}
