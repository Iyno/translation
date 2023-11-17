package com.japtoch.translation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.japtoch.translation.mapper")
@SpringBootApplication
public class TranslationApplication {

	public static void main(String[] args) {
		SpringApplication.run(TranslationApplication.class, args);
	}

}
