package com.example.demo.pojo;

import com.example.demo.anno.State;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Requirement {

    //@NotNull
    private Integer id;//主键ID

    @NotEmpty//为默认分组       (groups={update.class，add.class})
    private String requirementName;//名称

    @NotEmpty
    private String content;//需求内容

    @NotEmpty
    @State//使用自定义注解,state只能是 已发布 进行中 已完成
    private String state;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer createUser;//创建人ID

    @JsonFormat(pattern="yyyy MM dd HH:mm:ss")  //注意，MM和HH要大写！！！！！！
    private LocalDateTime createTime;//创建时间

}
