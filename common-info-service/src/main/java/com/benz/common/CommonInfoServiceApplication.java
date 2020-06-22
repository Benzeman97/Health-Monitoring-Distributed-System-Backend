package com.benz.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CommonInfoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommonInfoServiceApplication.class, args);
	}

}
