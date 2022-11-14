package com.academy.web.controller;


import com.academy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/users")
    public String getUsers(Model model) {
        var users = userService.getUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping(value = "/user")
    public String getUserDetail(@RequestParam Integer id, Model model) {
        var user = userService.getUserById(id);
        model.addAttribute(user);
        return "userDetails";
    }



}
