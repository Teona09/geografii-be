package org.geografii;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import springfox.documentation.swagger2.annotaions.EnableSwagger2;

//@EnableSwagger2
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MainSpringBoot {
    public static void main(String[] args) {
        SpringApplication.run(MainSpringBoot.class, args);
    }
}
