package com.example.springdemo2.customer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfiguration {

    @Value("${app.useFakeCustomerRepo:false}")
    private Boolean useFakeCustomerRepo;

    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            System.out.println("Command Line Runner hooray!");
        };
    }

    @Bean
    CustomerRepo customerRepo() {
        System.out.println("useFakeRepository = " + useFakeCustomerRepo);
        return useFakeCustomerRepo ?
                new CustomerFakeRepository() :
                new CustomerRepository();
    }
}
