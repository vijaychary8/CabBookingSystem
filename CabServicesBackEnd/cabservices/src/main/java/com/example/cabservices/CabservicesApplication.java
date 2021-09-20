package com.example.cabservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CabservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CabservicesApplication.class, args);
	}

}
