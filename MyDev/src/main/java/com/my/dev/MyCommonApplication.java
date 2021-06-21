package com.my.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MyCommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyCommonApplication.class, args);
    }

}
