package com.example.ecommerceapp.services;


import com.example.ecommerceapp.dto.OrderDTO;
import com.example.ecommerceapp.entities.Customer;
import com.example.ecommerceapp.entities.Order;
import com.example.ecommerceapp.entities.OrderItem;
import com.example.ecommerceapp.repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private final CustomerRepository customerRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public String placeOrder(OrderDTO orderDTO) {
        Order order = orderDTO.getOrder();
        String orderTrackingNumber = UUID.randomUUID().toString();
        order.setOrderTrackingNumber(orderTrackingNumber);
        Set<OrderItem> orderItems = orderDTO.getOrderItems();
        orderItems.forEach(orderItem -> order.addOrderItem(orderItem));
        order.setBillingAddress(orderDTO.getBillingAddress());
        order.setShippingAddress(orderDTO.getShippingAddress());
        Customer customer = orderDTO.getCustomer();
        customer.addOrder(order);
        customerRepository.save(customer);
        return orderTrackingNumber;
    }

}
