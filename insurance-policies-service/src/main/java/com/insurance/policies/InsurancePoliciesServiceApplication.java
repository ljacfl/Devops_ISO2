package com.insurance.policies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class InsurancePoliciesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsurancePoliciesServiceApplication.class, args);
	}

}
