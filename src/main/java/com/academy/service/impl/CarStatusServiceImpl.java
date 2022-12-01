package com.academy.service.impl;

import com.academy.model.CarStatus;
import com.academy.repository.CarStatusRepository;
import com.academy.service.interfaces.CarStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarStatusServiceImpl implements CarStatusService {
    private final CarStatusRepository carStatusRepository;


    @Override
    @Cacheable(value = "statusesCar")
    public CarStatus findByStatus(String status) {
        return carStatusRepository.findByStatus(status);
    }


}
