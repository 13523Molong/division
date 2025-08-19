package com.example.c2c.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("work")

public class Work {
    private Long id;
    private String title;
    private String description;
    private Long userId;  // 关联用户ID
    private LocalDateTime createTime;
}
