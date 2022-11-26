package com.academy.web.mapper;

import com.academy.model.CarStatus;
import com.academy.web.dto.CarDto;
import com.academy.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    Car carDtoToCar(CarDto carDto);

    @Mapping(source = "carStatus.status", target = "status")
    CarDto carToCarDto(Car car);


    List<CarDto> map (List<Car> cars);


}
