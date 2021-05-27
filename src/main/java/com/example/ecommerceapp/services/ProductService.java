package com.example.ecommerceapp.services;

import com.example.ecommerceapp.entities.Product;

import java.util.List;

public interface ProductService {

    Product saveProduct(Product product);

    List<Product> findAllProducts();

    List<Product> findByCategoryId(long id);

    List<Product> findByName(String name);

    Product findById(long id);

    Product update(Product product);

    void delete(long id);
}
