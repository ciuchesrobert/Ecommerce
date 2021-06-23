package com.example.ecommerceapp.repositories;

import com.example.ecommerceapp.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findById(long id);
}
