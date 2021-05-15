package com.example.ecommerceapp.services;

import com.example.ecommerceapp.entities.Product;

import java.util.List;

public interface ProductService{

    List<Product> findAllProducts();
    Product saveProduct (Product product);
    Product findById (long id);
    void delete(long id);
}
