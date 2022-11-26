package com.academy.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestDto {
    private Integer id;
    private String username;
    private String model;
    private String status;
}
