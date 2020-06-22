package com.benz.hospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HospitalInfoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalInfoServiceApplication.class, args);
	}

}
