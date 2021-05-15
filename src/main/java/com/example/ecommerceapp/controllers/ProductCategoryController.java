package com.example.ecommerceapp.controllers;

import com.example.ecommerceapp.entities.ProductCategory;
import com.example.ecommerceapp.services.ProductCategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;

    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @PostMapping("/category")
    public ProductCategory save(@RequestBody ProductCategory productCategory){
        return productCategoryService.saveCategory(productCategory);
    }

    @GetMapping("/category")
    public List<ProductCategory> findAllCategories(){
        return productCategoryService.findAllCategories();
    }

    @GetMapping("/category/{id}")
    public ProductCategory findByIdCategories(@PathVariable("id") long id){
        return productCategoryService.findById(id);
    }

    @DeleteMapping("/category/{id}")
    public void deleteProductCategory(@PathVariable("id") long id){
        productCategoryService.deleteById(id);
    }


}
