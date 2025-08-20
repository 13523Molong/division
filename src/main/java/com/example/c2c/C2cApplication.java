package com.example.c2c;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.example.c2c.mapper")

@SpringBootApplication
public class C2cApplication {

	public static void main(String[] args) {
		SpringApplication.run(C2cApplication.class, args);
	}

}
