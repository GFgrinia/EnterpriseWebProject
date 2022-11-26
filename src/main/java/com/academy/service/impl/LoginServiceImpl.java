package com.academy.service.impl;

import com.academy.repository.LoginRepository;
import com.academy.service.interfaces.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final LoginRepository loginRepository;

    @Override
    public boolean validateNewUser() {
        return false;
    }
}
