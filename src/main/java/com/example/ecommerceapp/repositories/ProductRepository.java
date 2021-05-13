package com.example.ecommerceapp.repositories;

import com.example.ecommerceapp.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findById(long id);
    Product update(Product product);
}
