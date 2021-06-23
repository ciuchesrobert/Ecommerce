package com.example.ecommerceapp.dto;

import com.example.ecommerceapp.entities.Address;
import com.example.ecommerceapp.entities.Customer;
import com.example.ecommerceapp.entities.Order;
import com.example.ecommerceapp.entities.OrderItem;
import lombok.Data;
import java.util.Set;


@Data
public class OrderDTO {
    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;



}
