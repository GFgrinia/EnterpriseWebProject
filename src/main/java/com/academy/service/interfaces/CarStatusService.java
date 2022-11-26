package com.academy.service.interfaces;

import com.academy.model.CarStatus;

public interface CarStatusService {
    CarStatus findByStatus(String status);

}
