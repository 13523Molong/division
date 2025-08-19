package com.example.demo.anno;


import com.example.demo.validation.StateValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;


@Documented//元注解
@Target({ElementType.FIELD})//元注解，指定用在哪些场景上，这里指定用在属性上（即成员变量）
@Retention(RetentionPolicy.RUNTIME)//元注解，运行时生效
@Constraint(validatedBy = {StateValidation.class})//里面指定一个类，来表明是哪个类提供校验规则

public @interface State {
    //提供校验失败后的提示信息
    String message() default "state中的参数只能是已发布或者进行中或者已完成";
    //指定分组
    Class<?>[] groups() default {};
    //负载，获取到State注解的附加信息
    Class<? extends Payload>[] payload() default { };
}

