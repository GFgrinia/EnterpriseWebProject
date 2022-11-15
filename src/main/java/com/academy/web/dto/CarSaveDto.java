package com.academy.web.dto;

import com.academy.model.CarStatus;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CarSaveDto {
    private String vendor;
    private String model;
    private Integer rent;
    private Integer statusId;
}
