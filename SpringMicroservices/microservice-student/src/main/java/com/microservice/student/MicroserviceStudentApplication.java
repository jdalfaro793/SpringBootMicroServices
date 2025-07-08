package com.microservice.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Main application class for the student microservice.
 * This class is responsible for starting the Spring Boot application and enabling service discovery.
 */
@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceStudentApplication {

	/**
	 * Main method to start the student microservice application.
	 * @param args Command line arguments.
	 */
	public static void main(String[] args) {
		SpringApplication.run(MicroserviceStudentApplication.class, args);
	}

}
