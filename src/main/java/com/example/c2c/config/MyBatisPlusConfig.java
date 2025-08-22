package com.example.c2c.config;

// com/example/c2c/config/MyBatisPlusConfig.java
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 标识为配置类，让Spring加载
public class MyBatisPlusConfig {

    /**
     * 配置分页插件
     * 作用：自动在SQL语句后添加 LIMIT 条件，实现分页
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 添加分页拦截器（支持MySQL、PostgreSQL等，自动适配数据库）
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return interceptor;
    }
}