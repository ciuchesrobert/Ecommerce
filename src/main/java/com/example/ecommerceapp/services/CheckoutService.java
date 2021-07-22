package com.example.ecommerceapp.services;


import com.example.ecommerceapp.dto.OrderDTO;
import com.example.ecommerceapp.entities.Order;
import freemarker.template.TemplateException;

import javax.mail.MessagingException;
import java.io.IOException;

public interface CheckoutService {
    Order placeOrder(OrderDTO orderDTO) throws MessagingException, TemplateException, IOException;
}
