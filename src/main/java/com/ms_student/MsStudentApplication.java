package com.ms_student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactivefeign.spring.config.EnableReactiveFeignClients;

@SpringBootApplication
@EnableReactiveFeignClients
public class MsStudentApplication {

	public static void main(String[] args) { SpringApplication.run(MsStudentApplication.class, args); }
}
