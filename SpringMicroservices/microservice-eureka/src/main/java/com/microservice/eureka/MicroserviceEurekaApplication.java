package com.microservice.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Main application class for the Eureka server.
 * This class is responsible for starting the Spring Boot application and enabling the Eureka server.
 */
@EnableEurekaServer
@SpringBootApplication
public class MicroserviceEurekaApplication {

	/**
	 * Main method to start the Eureka server application.
	 * @param args Command line arguments.
	 */
	public static void main(String[] args) {
		SpringApplication.run(MicroserviceEurekaApplication.class, args);
	}

}
