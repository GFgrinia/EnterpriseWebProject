package com.academy.web.controller;

import com.academy.model.Request;
import com.academy.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RequestController {
    private final RequestService requestService;

    @GetMapping("/requests")
    public List<Request> getAllRequests() {
        return requestService.getAllRequests();
    }


    @GetMapping("/requests/id={id}")
    public Request getRequestById(@PathVariable Integer id) {
        return requestService.getRequestById(id);
    }


    @GetMapping("/requests/status={status}")
    public List<Request> getRequestByStatus(@PathVariable Integer status) {
        return requestService.getRequestByStatus(status);
    }

}
