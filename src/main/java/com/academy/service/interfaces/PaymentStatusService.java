package com.academy.service.interfaces;

import com.academy.model.PaymentStatus;

public interface PaymentStatusService {
    PaymentStatus findByStatus(String Status);
}
