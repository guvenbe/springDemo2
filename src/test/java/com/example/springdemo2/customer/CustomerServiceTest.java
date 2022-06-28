package com.example.springdemo2.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerServiceTest {

    @Autowired
    private CustomerRepository customerRepository;
    private CustomerService underTest;

    @BeforeEach
    void setUp() {
        underTest = new CustomerService(customerRepository);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void getCustomers() {
        //given
        Customer blake = new Customer(
                1L,
                "Blake",
                "hello",
                "blake@yahoo.com"
        );

        Customer bob= new Customer(
                2L,
                "bob",
                "sdkls",
                "bob@yahoo.com"
        );

        customerRepository.saveAll(Arrays.asList(blake, bob));

        //when
        List<Customer> customers = underTest.getCustomers();
        //then
        assertEquals(2, customers.size());

    }

    @Test
    void getCustomer() {
        //given
        Customer blake = new Customer(
                1L,
                "Blake",
                "hello",
                "blake@yahoo.com"
        );
        customerRepository.save(blake);
        //when
        Customer actual = underTest.getCustomer(1L);
        //then
        assertEquals(1L,actual.getId());
        assertEquals("Blake",actual.getName());
        assertEquals("hello",actual.getPassword());
        assertEquals("blake@yahoo.com",actual.getEmail());

    }
}