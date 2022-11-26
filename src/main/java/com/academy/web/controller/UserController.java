package com.academy.web.controller;


import com.academy.service.interfaces.UserService;
import com.academy.web.dto.UserDto;
import com.academy.web.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public String getUsers(Model model) {
        var users = userService.getUsers();
        var usersDto = UserMapper.INSTANCE.map(users);
        model.addAttribute("users", usersDto);
        return "users";
    }

    @GetMapping(value = "/{id}")
    public String getUserDetail(@PathVariable Integer id, Model model) {
        var user = userService.getUserById(id);
        UserDto userDto = UserMapper.INSTANCE.userToUserDto(user);
        model.addAttribute("user", userDto);
        return "userDetails";
    }



}
