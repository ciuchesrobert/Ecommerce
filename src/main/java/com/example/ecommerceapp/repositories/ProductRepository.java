package com.example.ecommerceapp.repositories;

import com.example.ecommerceapp.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findById(long id);
    List<Product> findByCategoryId(long id);
    List<Product> findByNameContaining(String name);

}
