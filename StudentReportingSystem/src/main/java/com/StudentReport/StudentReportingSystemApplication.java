package com.StudentReport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2 // swagger tool used in this application
public class StudentReportingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentReportingSystemApplication.class, args);
	}

}
