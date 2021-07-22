package com.example.ecommerceapp.services;


import com.example.ecommerceapp.dto.OrderDTO;
import com.example.ecommerceapp.entities.Customer;
import com.example.ecommerceapp.entities.MailModel;
import com.example.ecommerceapp.entities.Order;
import com.example.ecommerceapp.entities.OrderItem;
import com.example.ecommerceapp.repositories.CustomerRepository;
import com.example.ecommerceapp.repositories.OrderRepository;
import freemarker.template.TemplateException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private final CustomerRepository customerRepository;
    private final EmailService emailService;
    private final OrderRepository orderRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository, EmailService emailService, OrderRepository orderRepository) {
        this.customerRepository = customerRepository;
        this.emailService = emailService;
        this.orderRepository = orderRepository;
    }

    @Override
    @Transactional
    public Order placeOrder(OrderDTO orderDTO) throws MessagingException, TemplateException, IOException {
        Order order = orderDTO.getOrder();
        String orderTrackingNumber = UUID.randomUUID().toString();
        order.setOrderTrackingNumber(orderTrackingNumber);
        Set<OrderItem> orderItems = orderDTO.getOrderItems();
        orderItems.forEach(orderItem -> order.addOrderItem(orderItem));
        order.setBillingAddress(orderDTO.getBillingAddress());
        order.setShippingAddress(orderDTO.getShippingAddress());
        order.setStatus("completed");
        Customer customer = orderDTO.getCustomer();
        customer.addOrder(order);
        customerRepository.save(customer);

        emailService.sendEmail(createMail(orderDTO, orderTrackingNumber));

        return orderRepository.findByOrderTrackingNumber(orderTrackingNumber);
    }

    private MailModel createMail(OrderDTO order, String orderTrackingNumber){
        MailModel mail = new MailModel();
        mail.setFirstName(order.getCustomer().getFirstName());
        mail.setLastName(order.getCustomer().getLastName());
        mail.setSubject("Gift It order");
        mail.setName("Gift It Team");
        mail.setFrom("ciuches.robert@gmail.com");
        mail.setTo(order.getCustomer().getEmail());
        mail.setContent("Thank you for your Order!" +
                "Your tracking number is" +  orderTrackingNumber);
        return mail;
    }

}
