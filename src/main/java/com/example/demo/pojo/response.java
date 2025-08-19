package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data           //加进set 和get方法
public class response<T> {
    private Integer isSuccess;
    private String message;
    private T data;

    //快速返回操作成功响应结果，带操作数据
    public static <E> response<E> success(E data){
        return new response<E>(1,"操作成功",data);
    }
   //快速返回操作成功响应结果，无操作数据
    public static response success(){
        return new response(1,"操作成功",null);
    }
    //返回操作失败结果，带原因
    public static response error(String message){
        return new response(0,message,null);
    }

}
