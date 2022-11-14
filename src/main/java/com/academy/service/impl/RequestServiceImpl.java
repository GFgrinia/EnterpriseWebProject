package com.academy.service.impl;

import com.academy.model.Request;
import com.academy.repository.RequestRepository;
import com.academy.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService {
    private final RequestRepository requestRepository;

    @Override
    public List<Request> getRequests(String status) {
        if (status != null) {
            return requestRepository.findRequestByStatus(status);
        } else {
            return requestRepository.findAll();
        }
    }

    @Override
    public List<Request> getRequests(Integer user_id) {
        return requestRepository.findRequestByUser(user_id);
    }
}
