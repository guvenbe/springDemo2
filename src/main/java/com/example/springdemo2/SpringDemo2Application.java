package com.example.springdemo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

public class SpringDemo2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringDemo2Application.class, args);
    }
}
