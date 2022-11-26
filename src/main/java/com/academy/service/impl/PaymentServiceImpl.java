package com.academy.service.impl;

import com.academy.model.Payment;
import com.academy.repository.PaymentRepository;
import com.academy.service.interfaces.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;


    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getPaymentById(Integer id) {
        return paymentRepository.findById(id).get();
    }

    @Override
    public void setPayment(Payment payment) {
        paymentRepository.save(payment);
    }
}
