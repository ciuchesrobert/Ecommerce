package com.example.ecommerceapp.services;


import com.example.ecommerceapp.dto.OrderDTO;

public interface CheckoutService {
    String placeOrder(OrderDTO orderDTO);
}
