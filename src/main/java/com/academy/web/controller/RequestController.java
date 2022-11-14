package com.academy.web.controller;

import com.academy.model.Request;
import com.academy.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class RequestController {
    private final RequestService requestService;

    @GetMapping("/requests")
    public String getRequests(@RequestParam(required = false) String status, Model model) {
        var requests = requestService.getRequests(status);
        model.addAttribute("requests" , requests);
        return "requests";
    }

    @GetMapping("/userRequests")
    public String getUserRequests(@RequestParam Integer id, Model model) {
        var requests = requestService.getRequests(id);
        model.addAttribute("requests" , requests);
        model.addAttribute("userId", id);
        return "userRequests";
    }

}
