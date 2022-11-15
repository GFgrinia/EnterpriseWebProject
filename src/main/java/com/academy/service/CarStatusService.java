package com.academy.service;

import com.academy.constant.CarStatuses;
import com.academy.model.CarStatus;

public interface CarStatusService {

    CarStatus findByStatus(String status);

    CarStatus findById(Integer id);
}
