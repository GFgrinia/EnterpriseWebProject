package com.academy.service;

import com.academy.model.Request;

import java.util.List;

public interface RequestService {
    List<Request> getAllRequests();

    Request getRequestById(Integer id);

    List<Request> getRequestByStatus(Integer status);
}
