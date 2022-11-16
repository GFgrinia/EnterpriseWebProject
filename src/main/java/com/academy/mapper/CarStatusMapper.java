package com.academy.mapper;

import com.academy.model.CarStatus;
import com.academy.dto.CarStatusDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarStatusMapper {

    CarStatusMapper INSTANCE = Mappers.getMapper(CarStatusMapper.class);

    CarStatus carStatusDtoToCarStatus(CarStatusDto carStatusDto);

    CarStatusDto carStatusToCarStatusDto(CarStatusDto carStatusDto);
}
