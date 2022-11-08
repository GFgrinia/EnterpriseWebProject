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
    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }

    @Override
    public Request getRequestById(Integer id) {
        return requestRepository.findById(id).get();
    }

    @Override
    public List<Request> getRequestByStatus(Integer status) {
        return requestRepository.findRequestByStatus(status);
    }


}
