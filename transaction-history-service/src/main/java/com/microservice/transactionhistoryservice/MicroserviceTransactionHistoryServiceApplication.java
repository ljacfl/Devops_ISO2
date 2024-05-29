package com.microservice.transactionhistoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

// Enable the service as a Eureka client
@EnableDiscoveryClient
// Exclude DataSourceAutoConfiguration class
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class MicroserviceTransactionHistoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceTransactionHistoryServiceApplication.class, args);
	}

}
