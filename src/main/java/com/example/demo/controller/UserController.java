package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.pojo.response;
import com.example.demo.service.UserService;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    //用户名和密码必须是6-16位的非空字符
    public response register(@Pattern(regexp = "^\\S{6,16}$") String username,
                             @Pattern(regexp = "^\\S{6,16}$")String password){
        User user = userService.findByUserName(username);
        if(user==null){
            userService.register(username,password);
            return response.success("注册成功");
        }
        else{
            return response.error("用户名已被占用");
        }
    }

    @PostMapping("/login")
    public response login(@Pattern(regexp = "^\\S{6,16}$") String username,
                          @Pattern(regexp = "^\\S{6,16}$")String password){

        User loginuser = userService.findByUserName(username);
        if(loginuser==null){
            return response.error("用户不存在");
        }
        if(loginuser.getPassword().equals(password)){
            return response.success("登录成功");
        }
        return response.error("密码错误");
    }

}
