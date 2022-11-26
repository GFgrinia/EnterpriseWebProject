package com.academy.service.interfaces;

import com.academy.model.Payment;

import java.util.List;

public interface PaymentService {
    List<Payment> getAllPayments();
    Payment getPaymentById(Integer id);

    void setPayment(Payment payment);
}
