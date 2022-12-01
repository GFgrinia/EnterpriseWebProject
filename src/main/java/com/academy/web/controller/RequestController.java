package com.academy.web.controller;

import com.academy.constant.MessageManager;
import com.academy.model.User;
import com.academy.service.interfaces.CarService;
import com.academy.service.interfaces.RequestService;
import com.academy.service.interfaces.RequestStatusService;
import com.academy.service.interfaces.UserService;
import com.academy.web.mapper.dto.CarDto;
import com.academy.web.mapper.dto.RequestCreateDto;
import com.academy.web.mapper.CarMapper;
import com.academy.web.mapper.RequestMapper;
import com.academy.web.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequiredArgsConstructor
public class RequestController {
    private final RequestService requestService;
    private final RequestStatusService requestStatusService;
    private final CarService carService;
    private final UserService userService;

    private final RequestMapper requestMapper;
    private final CarMapper carMapper;
    private final UserMapper userMapper;




    @GetMapping(value = "/requests")
    @PreAuthorize("#user.userRole.accessLevel >= T(com.academy.constant.UserRole).ROLE_USER.accessLevel")
    public String getRequests(@RequestParam(required = false) String status,
                              @RequestParam(required = false) Integer userId,
                              Model model,
                              User user) {

        var userDto = userMapper.userToUserDto(user);
        model.addAttribute("user", userDto);

        var requests = userId == null ? requestService.getRequests(status, user) : requestService.getRequestByUser(userId);
        var requestsDto = requestMapper.map(requests);

        model.addAttribute("requests", requestsDto);
        return "requests";
    }


    @GetMapping(value = "/requests/{id}")
    @PreAuthorize("#user.userRole.accessLevel >= T(com.academy.constant.UserRole).ROLE_USER.accessLevel")
    public String getRequests(@PathVariable Integer id,
                              @RequestParam(required = false) String status,
                              Model model,
                              User user) {

        var userDto = userMapper.userToUserDto(user);
        model.addAttribute("user", userDto);

        if (status != null) {
            requestService.changeRequest(id, status);
            return "redirect:/requests";
        } else {
            var request = requestService.getRequestById(id);
            var requestFullDataDto = requestMapper.requestToRequestFullDataDto(request);
            model.addAttribute("request", requestFullDataDto);
            return "requestDetails";
        }
    }



    @GetMapping(value = "/requestNew")
    @PreAuthorize("#user.userRole.accessLevel == T(com.academy.constant.UserRole).ROLE_USER.accessLevel")
    public String requestNew(@RequestParam Integer carId, User user, Model model) {
        RequestCreateDto requestCreateDto = new RequestCreateDto();
        model.addAttribute(requestCreateDto);

        var car = carService.getCarById(carId);
        CarDto carDto = carMapper.carToCarDto(car);
        model.addAttribute("car", carDto);

        model.addAttribute("currentUserId", user.getId());
        model.addAttribute("userRole", user.getUserRole().getRoleName());
        model.addAttribute("username", user.getName());

        return "requestNew";
    }


    @PostMapping(value = "/requestNew")
    public ModelAndView addRequest (@ModelAttribute(value = "requestCreateDto") RequestCreateDto requestCreateDto, ModelMap model) {
        var request = requestMapper.requestCreateDtoToRequest(requestCreateDto);
        request.setUser(userService.getUserById(requestCreateDto.getUserId()));
        request.setCar(carService.getCarById(requestCreateDto.getCarId()));;

        requestService.saveRequest(request);

        model.addAttribute("message", MessageManager.ADD_REQUEST_SUCCESS.label);
        return new ModelAndView("redirect:/requests", model);
    }


}
