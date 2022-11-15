package com.academy.service.impl;

import com.academy.model.Car;
import com.academy.model.CarStatus;
import com.academy.repository.CarRepository;
import com.academy.service.CarService;
import com.academy.service.CarStatusService;
import com.academy.web.dto.CarSaveDto;
import com.academy.web.mapper.CarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    private final CarStatusService carStatusService;

    @Override
    public List<Car> getCars(String status) {
        if (status != null) {
            return carRepository.findCarsByStatus(status);
        } else {
            return carRepository.findAll();
        }
    }

    @Override
    public void saveNewCar(CarSaveDto carSaveDto) {

        Car car = CarMapper.INSTANCE.carSaveDtoToCar(carSaveDto);
        CarStatus carStatus = carStatusService.findById(carSaveDto.getStatusId());
        car.setCarStatus(carStatus);

        carRepository.save(car);
    }


}
