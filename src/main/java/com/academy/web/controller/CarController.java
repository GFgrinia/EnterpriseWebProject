package com.academy.web.controller;

import com.academy.model.CarStatus;
import com.academy.service.CarService;
import com.academy.web.dto.CarSaveDto;
import com.academy.web.dto.CarStatusDto;
import com.academy.web.mapper.CarStatusMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

//    @GetMapping(value = "/cars")
//    public String getCars(@RequestParam(required = false) String status, Model model) {
//        var cars = carService.getCars(status);
//        model.addAttribute("cars", cars);
//        return "cars";
//    }


    @GetMapping(value = "/cars")
    public String getCars(@ModelAttribute(value = "carStatusDto") CarStatusDto carStatusDto, Model model) {
        if (carStatusDto.getStatus() == null) {
            CarStatusDto newCarStatusDto =  new CarStatusDto();
        }

        CarStatus carStatus = CarStatusMapper.INSTANCE.carStatusDtoToCarStatus(carStatusDto);
        var cars = carService.getCars(carStatus.getStatus());
        model.addAttribute("cars", cars);
        return "cars";
    }

    @PostMapping(value = "/cars")
    public String getCarsFilter(@ModelAttribute(value = "carStatusDto") CarStatusDto carStatusDto, Model model) {
        CarStatus carStatus = CarStatusMapper.INSTANCE.carStatusDtoToCarStatus(carStatusDto);
        var cars = carService.getCars(carStatus.getStatus());
        model.addAttribute("cars", cars);
        return "cars";
    }



    @GetMapping(value = "/addNewCar")
    public String addNewCar(Model model) {
        CarSaveDto carSaveDto = new CarSaveDto();
        model.addAttribute(carSaveDto);
        return "addNewCar";
    }


    @PostMapping(value = "/addNewCar")
    public String addCar(@ModelAttribute(value = "carSaveDto") CarSaveDto carSaveDto) {
        carService.saveNewCar(carSaveDto);
        return "redirect:/cars";
    }

}
