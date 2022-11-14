package com.academy.service;

import com.academy.model.User;
import com.academy.repository.UserRepository;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    User getUserById(Integer id);

    void saveUser(User user);
}
