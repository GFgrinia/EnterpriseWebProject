package com.academy.web.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Integer id;
    private String name;
    private String passport;
    private String email;
    private String roleName;
    private Integer accessLevel;


}
