package com.tensai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JobMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobMasterApplication.class, args);
	}

}
