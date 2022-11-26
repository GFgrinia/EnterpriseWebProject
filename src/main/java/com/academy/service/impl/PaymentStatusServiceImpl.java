package com.academy.service.impl;

import com.academy.model.PaymentStatus;
import com.academy.repository.PaymentStatusRepository;
import com.academy.service.interfaces.PaymentStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentStatusServiceImpl implements PaymentStatusService {

    private final PaymentStatusRepository paymentStatusRepository;

    @Override
    @Cacheable(value = "statuses")
    public PaymentStatus findByStatus(String status) {
        return paymentStatusRepository.findByStatus(status);
    }
}
