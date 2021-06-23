package com.example.ecommerceapp.controllers;

import com.example.ecommerceapp.dto.OrderDTO;
import com.example.ecommerceapp.services.CheckoutService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private final CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public String saveOrder(@RequestBody OrderDTO orderDTO){
        return checkoutService.placeOrder(orderDTO);
    }
}
