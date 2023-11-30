package ca.umd.lms.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GatewayApplication { //sets up a Spring Boot application with the class GatewayApplication as the primary configuration class, 
//and it launches the application by running the main method.
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
