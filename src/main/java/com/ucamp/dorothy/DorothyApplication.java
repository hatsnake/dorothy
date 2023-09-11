package com.ucamp.dorothy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ucamp.dorothy.mapper")
public class DorothyApplication {

	public static void main(String[] args) {
		SpringApplication.run(DorothyApplication.class, args);
	}

}
