package com.academy.web.controller;

import com.academy.web.dto.UserDto;
import com.academy.service.interfaces.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

//    1.All required fields not empty and not null
//    2.The email address validation
//    3.The password confirmation matches the password
//    4.The account doesn't already exist unique username and email.


    @GetMapping(value = "/login")
    public String userLogin(Model model) {
        return "login";
    }

    @GetMapping(value = "/user/registration")
    public String userRegistrationForm(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "registration";
    }

    @PostMapping(value = "/registration")

    // TODO: stop trash code use DTO instead

    public String addCar(@RequestParam String username,
                         @RequestParam String passport,
                         @RequestParam String email,
                         @RequestParam String password,
                         @RequestParam String confirm) {


        return "redirect:/";
    }
}
