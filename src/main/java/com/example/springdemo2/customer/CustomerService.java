package com.example.springdemo2.customer;

import com.example.springdemo2.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final static Logger LOGGER =
            LoggerFactory.getLogger(CustomerService.class);

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    List<Customer> getCustomers(){
        LOGGER.info("getCustomer was called,,,");
        return customerRepository.findAll();
    }

    Customer getCustomer(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(()-> {
                    NotFoundException notFoundException = new NotFoundException("customer with id  " + id + "  not found ");
                    LOGGER.error("error in getting customer {} ", id , notFoundException);
                    return notFoundException;
                });

    }

}
