package com.academy.service.impl;

import com.academy.model.User;
import com.academy.repository.UserRepository;
import com.academy.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public User getUserByUsername(String username) {
        return userRepository.findByName(username);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }
}

