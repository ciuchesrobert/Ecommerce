package com.example.ecommerceapp.repositories;

import com.example.ecommerceapp.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findById(long id);
}
