package com.example.ecommerceapp.controllers;

import com.example.ecommerceapp.entities.Product;
import com.example.ecommerceapp.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4200")
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
    public List<Product> findProductsByCategoryId(@RequestParam("category_id") long id){
        return productService.findByCategoryId(id);
    }

    @GetMapping("/product/{id}")
    public Product findByIdProducts(@PathVariable("id") long id){
        return productService.findById(id);
    }

    @PutMapping("/product/{id}")
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

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable("id") long id){
        productService.delete(id);
    }
}
