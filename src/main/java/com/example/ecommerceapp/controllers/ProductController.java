package com.example.ecommerceapp.controllers;

import com.example.ecommerceapp.entities.Product;
import com.example.ecommerceapp.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product")
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @GetMapping("/product")
    public List<Product> findAllProducts(){
        return productService.findAllProducts();
    }

    @GetMapping("/product/{id}")
    public Product findByIdProducts(@PathVariable("id") long id){
        return productService.findById(id);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable("id") long id){
        productService.delete(id);
    }
}
