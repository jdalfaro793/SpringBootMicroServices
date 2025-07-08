package com.microservice.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Main application class for the API Gateway.
 * This class is responsible for starting the Spring Boot application and enabling service discovery.
 */
@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceGatewayApplication {

	/**
	 * Main method to start the API Gateway application.
	 * @param args Command line arguments.
	 */
	public static void main(String[] args) {
		SpringApplication.run(MicroserviceGatewayApplication.class, args);
	}

}