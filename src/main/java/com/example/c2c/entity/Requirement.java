package com.example.c2c.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("requirement")
public class Requirement {
    private Long id;
    private String title;
    private String content;  // 内容
    private Long userId;  // 用户ID
    private LocalDateTime createTime;
}
