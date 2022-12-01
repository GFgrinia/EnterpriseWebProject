package com.academy.service.interfaces;

import com.academy.model.Payment;
import com.academy.model.Request;
import com.academy.model.User;

import java.util.List;

public interface PaymentService {
    List<Payment> getPayments(String status, User user);

    Payment getPaymentByRequest(Request request);

    List<Payment> getPaymentByUser(Integer id);

    void savePayment(Payment payment);
}
