package com.academy.service.interfaces;

import com.academy.model.Request;
import com.academy.model.User;

import java.util.List;

public interface RequestService {


    /**
     *
     * @param status filter requests by certain status, can be null
     * @param user filter requests by certain user, can't be null
     * @return all request filtered by provided parameters
     *
     */
    List<Request> getRequests(String status, User user);

    Request getRequestById(Integer id);

    List<Request> getRequestByUser(Integer id);


    void providePayment(Integer id);

    void provideReturn(Integer id);
}

