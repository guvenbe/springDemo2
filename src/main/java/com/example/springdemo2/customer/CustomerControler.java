package com.example.springdemo2.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Deprecated
@RestController
@RequestMapping(path = "api/v1/customer")
public class CustomerControler {
    private final CustomerService customerService;

    @Autowired
    public CustomerControler(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping(value = "all")
    List<Customer> getCusomers() {
        return customerService.getCustomers();
    }

    @PostMapping
    void createNewCustomer(@RequestBody Customer customer){
        System.out.println("POST REQUEST....");
        System.out.println(customer);
    }

    @PutMapping
    void updateCustomer(@RequestBody Customer customer){
        System.out.println("UPDATE PUT REQUEST....");
        System.out.println(customer);
    }
    @DeleteMapping(path = "{customerId}")
    void deleteCustomer(@PathVariable("customerId") Long id){
        System.out.println("DELETE REQUEST FOR CUSTOMER WITH ID...." + id);
    }
}
