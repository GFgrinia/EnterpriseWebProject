package com.academy.web.mapper;

import com.academy.model.User;
import com.academy.web.dto.UserDto;
import com.academy.web.dto.LoginDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User userRegistrationDtoToUser(LoginDto loginDto);

    @Mapping(source = "userRole.accessLevel", target = "accessLevel")
    @Mapping(source = "userRole.roleName", target = "roleName")
    UserDto userToUserDto(User user);

    List<UserDto> map (List<User> users);
}
