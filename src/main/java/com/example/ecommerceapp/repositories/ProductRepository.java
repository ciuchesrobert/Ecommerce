package com.example.ecommerceapp.repositories;

import com.example.ecommerceapp.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findById(long id);
    Page<Product> findByCategoryId(long id, Pageable pageable);
    Page<Product> findByNameContaining(String name, Pageable pageable);

}
