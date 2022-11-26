package com.academy.web.controller;

import com.academy.model.User;
import com.academy.service.interfaces.RequestService;
import com.academy.web.mapper.RequestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/requests")
public class RequestController {
    private final RequestService requestService;
    private final RequestMapper requestMapper;


    @GetMapping
    public String getRequests(@RequestParam(required = false) String status,
                              @RequestParam(required = false) Integer id,
                              Model model,
                              User user) {

        model.addAttribute("userRole", user.getUserRole().getRoleName());
        model.addAttribute("username", user.getName());

        if (id != null) {
            var request = requestService.getRequestById(id);
            var requestFullDataDto = requestMapper.requestToRequestFullDataDto(request);
            model.addAttribute("request", requestFullDataDto);
            return "requestDetails";
        } else {
            var requests = requestService.getRequests(status, user);
            var requestsDto = requestMapper.map(requests);
            model.addAttribute("requests", requestsDto);
            return "requests";
        }
    }


    @GetMapping("pay/{userId}/{requestId}")
    public String getPayRequest(@PathVariable Integer userId, @PathVariable Integer requestId) {
        requestService.providePayment(requestId);
        return "redirect:/requests/user/" + userId;
    }


    @GetMapping("return/{userId}/{requestId}")
    public String getReturnRequest(@PathVariable Integer userId, @PathVariable Integer requestId) {
        requestService.provideReturn(requestId);
        return "redirect:/requests/user/" + userId;
    }
}
