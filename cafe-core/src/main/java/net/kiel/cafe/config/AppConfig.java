package net.kiel.cafe.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"net.kiel.cafe,repository", "net.kiel.cafe.service"})
public class AppConfig {
   

}
