package net.kiel.cafe.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages={"net.kiel.cafe"})
public class CafeWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(CafeWebApplication.class, args);
    }
}
