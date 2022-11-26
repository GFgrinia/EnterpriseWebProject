package com.academy.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestFullDataDto {
    private Integer id;
    private String username;
    private String userRole;
    private String model;
    private Integer rent;
    private Integer rentDuration;
    private String date;
    private String status;
    private String comment;
}
