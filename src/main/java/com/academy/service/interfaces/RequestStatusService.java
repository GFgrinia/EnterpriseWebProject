package com.academy.service.interfaces;

import com.academy.model.RequestStatus;

public interface RequestStatusService {
    RequestStatus findByStatus(String status);
}
