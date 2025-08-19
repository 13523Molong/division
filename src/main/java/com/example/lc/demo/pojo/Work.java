package com.example.lc.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Work
{
    private Integer id;
    private String title;
    private String description;
    private Integer userId;
    private LocalDateTime createTime=LocalDateTime.now();
}
