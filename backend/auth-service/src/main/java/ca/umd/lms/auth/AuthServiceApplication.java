package ca.umd.lms.auth;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients({"ca.umd.lms.auth", "ca.utoronto.lms.shared"})
@ComponentScan({"ca.umd.lms.auth", "ca.utoronto.lms.shared"})
@OpenAPIDefinition(
        info =
                @Info(
                        title = "Auth API",
                        version = "1.0",
                        description = "Documentation Auth API v1.0"))
public class AuthServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class, args);
    }
}// the AuthServiceApplication class configures and starts a Spring Boot application with Eureka client support, Feign client capabilities, 
//component scanning for specific packages, and OpenAPI documentation generation. It is a typical configuration class for a microservices-based authentication service.
