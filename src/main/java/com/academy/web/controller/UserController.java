package com.academy.web.controller;


import com.academy.model.User;
import com.academy.service.interfaces.UserService;
import com.academy.web.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping(value = "/users")
    @PreAuthorize("#user.userRole.accessLevel >= T(com.academy.constant.UserRole).ROLE_USER.accessLevel")
    public String getUsers(User user,Model model) {

        var userDto = userMapper.userToUserDto(user);
        model.addAttribute("user", userDto);

        var users = userService.getUsers();
        var usersDto = UserMapper.INSTANCE.map(users);
        model.addAttribute("users", usersDto);
        return "users";

    }

    @GetMapping(value = "/users/{id}")
    @PreAuthorize("#user.userRole.accessLevel >= T(com.academy.constant.UserRole).ROLE_USER.accessLevel")
    public String getUserDetail(@PathVariable Integer id, User user, Model model) {

        var userDto = userMapper.userToUserDto(user);
        model.addAttribute("user", userDto);

        var userById = userService.getUserById(id);
        var userByIdDto = userMapper.userToUserDto(userById);
        model.addAttribute("userById", userByIdDto);
        return "userDetails";
    }

}
