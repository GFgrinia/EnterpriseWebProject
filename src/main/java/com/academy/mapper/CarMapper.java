package com.academy.mapper;

import com.academy.dto.CarDto;
import com.academy.model.Car;
import com.academy.dto.CarSaveDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);


    Car carSaveDtoToCar(CarSaveDto carSaveDto);

    CarDto carToCarDto(Car car);

}
