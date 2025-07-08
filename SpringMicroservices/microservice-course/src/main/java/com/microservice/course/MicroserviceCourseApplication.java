package com.microservice.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Main application class for the course microservice.
 * This class is responsible for starting the Spring Boot application, enabling Feign clients, and enabling service discovery.
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceCourseApplication {

	/**
	 * Main method to start the course microservice application.
	 * @param args Command line arguments.
	 */
	public static void main(String[] args) {
		SpringApplication.run(MicroserviceCourseApplication.class, args);
	}

}
