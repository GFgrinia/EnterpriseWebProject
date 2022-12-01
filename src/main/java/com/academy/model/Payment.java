package com.academy.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne()
    @JoinColumn(name = "payment_status_id")
    private PaymentStatus paymentStatus;
    @ManyToOne()
    @JoinColumn(name = "request_id")
    private Request request;
    @Column(name = "amount")
    private Integer amount;

}
