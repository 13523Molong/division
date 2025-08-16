package com.example.lc.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Requirement
{
    private Integer id;
    private String title;
    private String content;
    private Integer publisherId;
    private LocalDateTime createTime=LocalDateTime.now();
    private LocalDateTime updateTime=LocalDateTime.now();
    private String status="PUBLISHED";
    private String phase="PHASE_1";
    private Integer acceptorId;
}
