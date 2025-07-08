package com.microservice.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Main application class for the configuration server.
 * This class is responsible for starting the Spring Boot application and enabling the configuration server.
 */
@EnableConfigServer
@SpringBootApplication
public class MicroserviceConfigApplication {

	/**
	 * Main method to start the configuration server application.
	 * @param args Command line arguments.
	 */
	public static void main(String[] args) {
		SpringApplication.run(MicroserviceConfigApplication.class, args);
	}

}
