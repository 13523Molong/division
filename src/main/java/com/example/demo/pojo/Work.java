package com.example.demo.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.groups.Default;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDateTime;

@Data
public class Work {
    @NotNull
    private Integer id;//主键ID

    @NotEmpty
    @Pattern(regexp = "^\\S{1,10}$")//1到10个字符以内
    private String title;//作品标题
    @NotEmpty
    private String content;//作品内容

    @NotEmpty
    @URL
    private String coverImg;//封面图像

    @NotEmpty
  //  @State//使用自定义注解
    private String state;//发布状态 待售|已出售

    private Integer createUser;//创建人ID
    @JsonFormat(pattern="yyyy MM dd HH:mm:ss")  //注意，MM和HH要大写  输出到前端的格式
    private LocalDateTime createTime;//创建时间

    public interface update extends Default {};
}
