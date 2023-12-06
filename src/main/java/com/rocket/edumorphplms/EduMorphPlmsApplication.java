package com.rocket.edumorphplms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication   
@ComponentScan(basePackages = "com.rocket.edumorphplms")
@EntityScan(basePackages = "com.rocket.edumorphplms.entity")
@EnableJpaRepositories(basePackages = "com.rocket.edumorphplms.repository")
public class EduMorphPlmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduMorphPlmsApplication.class, args);
    }

}
