package com.academy.service;

import com.academy.model.Request;

import java.util.List;

public interface RequestService {
    List<Request> getRequests(String status);
    List<Request> getRequests(Integer id);

//    Request getRequestById(Integer userId);
//
//    List<Request> getRequestByStatus(Integer status);
}
