package com.example.demo.validation;

import com.example.demo.anno.State;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

//实现接口ConstraintValidator<,>，第一个参数填要实现的注解，第二个参数填要校验的数据类型
public class StateValidation implements ConstraintValidator<State,String> {

    //value是要校验的数据
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context){
        if(value==null) {
            return false;
        }
        if(value.equals("已发布")||value.equals("进行中")||value.equals("已完成")){
            return true;
        }
        return false;

    }

}
