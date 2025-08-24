package com.example.demo.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Work {
  //  @NotNull
    private Integer id;//主键ID

    @NotEmpty
    @Pattern(regexp = "^\\S{1,10}$")//1到10个字符以内
    private String title;//作品标题
    @NotEmpty
    private String content;//作品内容

    @NotNull
    private Integer createUser;//创建人ID
    @JsonFormat(pattern="yyyy MM dd HH:mm:ss")  //注意，MM和HH要大写  输出到前端的格式
    private LocalDateTime createTime;//创建时间
    @JsonFormat(pattern="yyyy MM dd HH:mm:ss")  //注意，MM和HH要大写  输出到前端的格式
    private LocalDateTime updateTime;//更新时间


}
