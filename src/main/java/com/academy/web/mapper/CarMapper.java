package com.academy.web.mapper;

import com.academy.model.Car;
import com.academy.web.dto.CarSaveDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    CarSaveDto carToCarSaveDto(Car car);

    Car carSaveDtoToCar(CarSaveDto carSaveDto);
}
