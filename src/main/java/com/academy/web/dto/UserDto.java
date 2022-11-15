package com.academy.web.dto;

import lombok.Data;

@Data
public class UserDto {
    private Integer id;
    private String name;
    private String passport;
    private String email;
}
