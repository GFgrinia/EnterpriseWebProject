package com.academy.web.dto;

import com.academy.model.CarStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDto {
    private Integer id;
    private String vendor;
    private String model;
    private String status;
    private Integer rent;
}
