package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
//import net.minidev.json.annotate.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;

@Data
public class User {

    //在传入参数时id不能没有
    @NotNull     //不能没有
    private Integer id;
    private String username;

    @JsonIgnore//在返回给前端时转换为json时忽略这个变量，即不会把密码返回
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    //@Getter(onMethod_ = @JsonIgnore) // ✅ Lombok特定语法
    private String password;

    @NotEmpty   //不能为空
    @Pattern(regexp = "^\\S{1,10}$")    //并且长度为1到10个字符之间
    private String nickname;

    @NotEmpty
    @Email      //符合email的名称格式
    private String email;
    private String userPrc;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
