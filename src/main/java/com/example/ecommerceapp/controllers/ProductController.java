package com.example.ecommerceapp.controllers;

import com.example.ecommerceapp.entities.Product;
import com.example.ecommerceapp.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(path = "/api")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @GetMapping("/products")
    public Page<Product> findProductsByCategoryId(@RequestParam("category_id") long id, Pageable pageable){
        return productService.findByCategoryId(id, pageable);
    }

    @GetMapping("/products/search")
    public Page<Product> findProductsByName(@RequestParam("keyword") String keyword, Pageable pageable){
        return productService.findByName(keyword, pageable);
    }

    @GetMapping("/products/{id}")
    public Product findByIdProduct(@PathVariable("id") long id){
        return productService.findById(id);
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
        Optional<Product> productFromDatabase = Optional.ofNullable(productService.findById(id));
        if (productFromDatabase.isPresent()) {
            productFromDatabase.get().setSku(product.getSku());
            productFromDatabase.get().setName(product.getName());
            productFromDatabase.get().setDescription(product.getDescription());
            productFromDatabase.get().setUnitPrice(product.getUnitPrice());
            productFromDatabase.get().setImageUrl(product.getImageUrl());
            productFromDatabase.get().setActive(product.getActive());
            productFromDatabase.get().setUnitsInStock(product.getUnitsInStock());
            productFromDatabase.get().setDateCreated(product.getDateCreated());
            productFromDatabase.get().setLastUpdated(product.getLastUpdated());
            return productService.saveProduct(productFromDatabase.get());
        }
        return productService.update(product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable("id") long id){
        productService.delete(id);
    }
}
