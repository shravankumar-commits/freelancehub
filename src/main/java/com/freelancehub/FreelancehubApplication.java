package com.freelancehub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class FreelancehubApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreelancehubApplication.class, args);
	}

}