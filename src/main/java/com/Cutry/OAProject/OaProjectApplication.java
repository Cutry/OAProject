package com.Cutry.OAProject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.Cutry.OAProject.Dao")
public class OaProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(OaProjectApplication.class, args);
	}

}

