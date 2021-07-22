package com.example.ecommerceapp.controllers;

import com.example.ecommerceapp.dto.OrderDTO;
import com.example.ecommerceapp.entities.Order;
import com.example.ecommerceapp.services.CheckoutService;
import freemarker.template.TemplateException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private final CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public ResponseEntity<Order> saveOrder(@RequestBody OrderDTO orderDTO) throws MessagingException, TemplateException, IOException {
        return ResponseEntity.ok(checkoutService.placeOrder(orderDTO));
    }
}
