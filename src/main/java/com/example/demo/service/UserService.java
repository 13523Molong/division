package com.example.demo.service;

import com.example.demo.pojo.User;
import jakarta.validation.constraints.Pattern;

public interface UserService {
    User findByUserName(String username);

    void register(String username,String password);
}
