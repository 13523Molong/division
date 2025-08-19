package com.example.lc.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result
{
    private  int  code;
    private String msg;
    private Object data;
    public  static   Result success()
    {
        Result r = new Result();
        r.setCode(1);
        r.setMsg("success");
        return r;
    }
    public  static Result success(Object object)
    {
        Result  r = new Result();
        r.setCode(1);
        r.setMsg("success");
        r.setData(object);
        return r;
        
    }
    public static Result error(String msg)
    {
        Result r = new Result();
        r.setCode(0);
        r.setMsg(msg);
        return r;
    }
    
}