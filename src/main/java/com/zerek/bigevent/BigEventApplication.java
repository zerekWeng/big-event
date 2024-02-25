package com.zerek.bigevent;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zerek.bigevent.mapper")
public class BigEventApplication {

	public static void main(String[] args) {
		SpringApplication.run(BigEventApplication.class, args);
	}

}
