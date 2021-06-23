package com.my.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@EnableJpaAuditing
@SpringBootApplication
public class MyDevApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyDevApplication.class, args);
    }

}
