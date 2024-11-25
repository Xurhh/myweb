package com.xrh.xrh_application;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xrh.xrh_application.mapper")
public class XrhApplication {

	public static void main(String[] args) {
		System.out.println("success to open the application");
		SpringApplication.run(XrhApplication.class, args); 
	}

}
																		