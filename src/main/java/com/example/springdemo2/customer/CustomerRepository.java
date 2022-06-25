package com.example.springdemo2.customer;

import java.util.Collections;
import java.util.List;

public class CustomerRepository implements CustomerRepo {
    @Override
    public List<Customer> getcustomers() {
        //TODO conect to real db
        return Collections.singletonList(
                new Customer(1L, "TODO", "todo", "email@gamil.com")
        );
    }
}
