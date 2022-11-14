package com.academy.web.controller;

import com.academy.model.Payment;
import com.academy.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @GetMapping("/payments")
    public String getAllPayments(Model model) {
        var payments = paymentService.getAllPayments();
        model.addAttribute("payments", payments);
        return "payments";
    }

    @GetMapping("/payments/id={id}")
    public Payment getPaymentById(@PathVariable Integer id) {
        return paymentService.getPaymentById(id);

    }
}
