package com.example.springdemo2.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class CustomerConfiguration {

    @Value("${app.useFakeCustomerRepo:false}")
    private Boolean useFakeCustomerRepo;

    @Value("${info.company.name}")
    private String companyName;

    @Autowired
    private Environment environment;

    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            System.out.println("Command Line Runner hooray!");
            System.out.println("CompanyName = "  +  companyName);
            System.out.println(environment.getProperty("info.app.version"));
        };
    }

    @Bean
    CustomerRepo customerRepo() {
        System.out.println("useFakeRepository = " + useFakeCustomerRepo);
        return new CustomerFakeRepository();
    }
}
