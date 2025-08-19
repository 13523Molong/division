package com.example.lc.demo.mapper;

import com.example.lc.demo.pojo.Result;
import com.example.lc.demo.pojo.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface LoginMapper
{
    @Insert("INSERT INTO users(username, password) VALUES(#{username}, #{password})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(User user);
    
    @Select("select * from users where username=#{username} and password=#{password}")
    public User select(User  user);
    
    @Select("SELECT EXISTS(SELECT 1 FROM users WHERE username = #{username})")
    boolean existByUsername(@Param("username") String username);
    
}
