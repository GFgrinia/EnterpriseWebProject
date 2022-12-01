package com.academy.service.impl;

import com.academy.model.RequestStatus;
import com.academy.repository.RequestStatusRepository;
import com.academy.service.interfaces.RequestStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RequestStatusServiceImpl implements RequestStatusService {

    private final RequestStatusRepository requestStatusRepository;

    @Override
    @Cacheable(value = "statusesRequest")
    public RequestStatus findByStatus(String status) {
        return requestStatusRepository.findByStatus(status);
    }
}
