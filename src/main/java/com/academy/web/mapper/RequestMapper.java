package com.academy.web.mapper;

import com.academy.model.Car;
import com.academy.model.Request;
import com.academy.web.dto.RequestCreateDto;
import com.academy.web.dto.RequestDto;
import com.academy.web.dto.RequestFullDataDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

// TODO: 23.11.2022  try to --> users ExampleMapper.class 
@Mapper(componentModel = "spring")
public interface RequestMapper {

    RequestMapper INSTANCE = Mappers.getMapper(RequestMapper.class);


    @Mapping(source = "user.name", target = "username")
    @Mapping(source = "requestStatus.status", target = "status")
    @Mapping(source = "car.rent", target = "rent")
    @Mapping(source = "car", target = "model", qualifiedByName = "carToModel")
    @Mapping(source = "lastChangeDate", target = "date", qualifiedByName = "timestampToSting")
    RequestFullDataDto requestToRequestFullDataDto(Request request);


    @Mapping(source = "user.name", target = "username")
    @Mapping(source = "requestStatus.status", target = "status")
    @Mapping(source = "car", target = "model", qualifiedByName = "carToModel")
    RequestDto requestToRequestDto(Request request);


    Request requestCreateDtoToRequest(RequestCreateDto requestCreateDto);


    List<RequestDto> map(List<Request> requests);


    @Named("carToModel")
    static String carToModel(Car car) {
        return car.getVendor() + " " + car.getModel();
    }

    @Named("timestampToSting")
    static String timestampToSting(Timestamp timestamp) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm",Locale.US);
        return formatter.format(timestamp.toLocalDateTime());
    }
}
