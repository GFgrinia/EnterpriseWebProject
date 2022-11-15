package com.academy.service.impl;

import com.academy.constant.CarStatuses;
import com.academy.model.CarStatus;
import com.academy.repository.CarStatusRepository;
import com.academy.service.CarStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarStatusServiceImpl implements CarStatusService {
    private final CarStatusRepository carStatusRepository;


    // TODO: change findByStatusSlow to findByStatus
    @Override
    @Cacheable(value = "statuses")
    public CarStatus findByStatus(String status) {
        return carStatusRepository.findByStatusSlow(status);
    }

    @Override
    @Cacheable(value = "statuses")
    public CarStatus findById(Integer id) {
        return carStatusRepository.findById(id).get();
    }
}
