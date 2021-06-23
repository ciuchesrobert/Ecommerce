package com.example.ecommerceapp.services;

import com.example.ecommerceapp.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    Product saveProduct(Product product);

    List<Product> findAllProducts();

    Page<Product> findByCategoryId(long id, Pageable pageable);

    Page<Product> findByName(String name, Pageable pageable);

    Product findById(long id);

    Product update(Product product);

    void delete(long id);
}
