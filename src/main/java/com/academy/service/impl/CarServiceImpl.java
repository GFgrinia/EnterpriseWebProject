package com.academy.service.impl;

import com.academy.dto.CarDto;
import com.academy.dto.CarStatusDto;
import com.academy.mapper.CarStatusMapper;
import com.academy.model.Car;
import com.academy.model.CarStatus;
import com.academy.repository.CarRepository;
import com.academy.service.CarService;
import com.academy.service.CarStatusService;
import com.academy.dto.CarSaveDto;
import com.academy.mapper.CarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    private final CarStatusService carStatusService;

    @Override
    public List<CarDto> getCars(String status) {
        List<CarDto> carsDto = new ArrayList<>();
        List<Car> cars = status != null ? carRepository.findCarsByStatus(status) : carRepository.findAll();
        CarDto carDto;

        for (Car car : cars) {
            carDto = CarMapper.INSTANCE.carToCarDto(car);
            carDto.setStatus(car.getCarStatus().getStatus());
            carsDto.add(carDto);
        }
        return carsDto;
    }


    @Override
    public void saveNewCar(CarSaveDto carSaveDto) {
        Car car = CarMapper.INSTANCE.carSaveDtoToCar(carSaveDto);
        CarStatus carStatus = carStatusService.findById(carSaveDto.getStatusId());
        car.setCarStatus(carStatus);

        carRepository.save(car);
    }


    @Override
    public CarDto getCarById(Integer id) {
        var car = carRepository.findById(id).get();
        var carDto = CarMapper.INSTANCE.carToCarDto(car);
        carDto.setStatus(car.getCarStatus().getStatus());
        return carDto;
    }

    @Override
    public String deleteCar(Integer id) {
        Optional<Car> car = carRepository.findById(id);

        if (car.isPresent()) {
            carRepository.deleteById(id);
            return "Car Deleted";
        }else{
            return "No such car";        }


    }


}
