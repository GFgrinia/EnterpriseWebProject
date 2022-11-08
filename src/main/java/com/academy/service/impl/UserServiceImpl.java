package com.academy.service.impl;

import com.academy.repository.LoginRepository;
import com.academy.repository.UserRepository;
import com.academy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final LoginRepository loginRepository;

    @Override
    public UserRepository getUserRepository() {
        return userRepository;
    }

//    @Override
//    public String getPassword(Integer id) {
//        Login login = loginRepository.findById(id).get();
//        return login.getPassword();
//    }
}

