package com.academy.web.controller;

import com.academy.model.User;
import com.academy.service.interfaces.PaymentService;
import com.academy.web.mapper.PaymentMapper;
import com.academy.web.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;
    private final UserMapper userMapper;
    private final PaymentMapper paymentMapper;

    @GetMapping("/payments")
    public String getAllPayments(@RequestParam(required = false) String status,
                                 @RequestParam(required = false) Integer userId,
                                 Model model,
                                 User user) {

        var userDto = userMapper.userToUserDto(user);
        model.addAttribute("user", userDto);

        var payments = userId == null ? paymentService.getPayments(status, user) : paymentService.getPaymentByUser(userId);
        var paymentsDto = paymentMapper.map(payments);
        model.addAttribute("payments", paymentsDto);

        return "payments";
    }

}