package com.example.ecommerceapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "address")
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "zip_code")
    private String zipCode;

//    @ManyToOne
//    @JoinColumn(name = "customer_id", nullable = false)
//    @JsonIgnoreProperties("orders")
//    private Customer customer;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Order order;
}
