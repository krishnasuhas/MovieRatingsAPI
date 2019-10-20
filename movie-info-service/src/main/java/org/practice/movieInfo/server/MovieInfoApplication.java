package org.practice.movieInfo.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = "org.practice.movieInfo")
public class MovieInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieInfoApplication.class, args);
    }

}
