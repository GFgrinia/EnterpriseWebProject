package com.academy.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestUserDto {
    private Integer id;
    private String model;
    private Integer rent;
    private Integer rentDuration;
    private String date;
    private String status;
}
