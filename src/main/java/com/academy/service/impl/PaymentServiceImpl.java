package com.academy.service.impl;

import com.academy.constant.UserRole;
import com.academy.model.Payment;
import com.academy.model.Request;
import com.academy.model.User;
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
    public List<Payment> getPayments(String status, User user) {

        if (user != null) {
            String currentUserRoleName = user.getUserRole().getRoleName();

            if (currentUserRoleName.equals(UserRole.ROLE_ADMIN.roleName)) {
                return status != null ?  paymentRepository.findPaymentByStatus(status) : paymentRepository.findAll();
            }

            if (currentUserRoleName.equals(UserRole.ROLE_USER.roleName)) {
                if (status != null) {
                    return paymentRepository.findPaymentByUserAndPaymentStatus(user.getId(), status);
                } else {
                    return paymentRepository.findPaymentByUser(user.getId());
                }
            }
        }
        return null;
    }


    @Override
    public Payment getPaymentByRequest(Request request) {
        return paymentRepository.findPaymentByRequest(request);
    }


    @Override
    public List<Payment> getPaymentByUser(Integer id) {
        return paymentRepository.findPaymentByUser(id);
    }

    @Override
    public void savePayment(Payment payment) {
        paymentRepository.save(payment);
    }
}
