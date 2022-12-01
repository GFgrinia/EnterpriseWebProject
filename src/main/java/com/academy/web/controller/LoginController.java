package com.academy.web.controller;

import com.academy.constant.MessageManager;
import com.academy.web.dto.LoginDto;
import com.academy.service.interfaces.LoginService;
import com.academy.web.mapper.LoginMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;
    private final LoginMapper loginMapper;


    @GetMapping(value = {"/", "/index"})
    public String showMainPage() {
        return "redirect:/cars";
    }


    @GetMapping(value = "/registration")
    public String userRegistrationForm(Model model) {
        var userRegistrationDto = new LoginDto();
        model.addAttribute("loginDto", userRegistrationDto);
        return "registration";
    }


    @PostMapping(value = "/registration")
    public ModelAndView userRegistration(@ModelAttribute(value = "loginDto") LoginDto loginDto, ModelMap model) {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<LoginDto>> violations = validator.validate(loginDto);
        List<String> messages = new ArrayList<>();
        model.addAttribute("messages", messages);

        if (violations.size() > 0) {

            for (ConstraintViolation<LoginDto> violation : violations) {
                messages.add(violation.getMessage());
            }

            return new ModelAndView("/registration", model);

        } else {

            var login = loginMapper.loginDtoToLogin(loginDto);
            String creatingUserResult = loginService.validateNewUser(login);
            messages.add(creatingUserResult);

            if (creatingUserResult.equals(MessageManager.REGISTRATION_SUCCESSFUL.label)) {
                return new ModelAndView("redirect:/cars", model);
            } else {
                return new ModelAndView("/registration", model);
            }
        }

    }

}
