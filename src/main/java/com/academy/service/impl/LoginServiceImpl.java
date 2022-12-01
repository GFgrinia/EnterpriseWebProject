package com.academy.service.impl;

import com.academy.constant.MessageManager;
import com.academy.constant.UserRole;
import com.academy.model.Login;
import com.academy.model.Role;
import com.academy.model.User;
import com.academy.repository.LoginRepository;
import com.academy.repository.RoleRepository;
import com.academy.repository.UserRepository;
import com.academy.service.interfaces.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final LoginRepository loginRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    @Transactional
    public String validateNewUser(Login login) {

        if (userRepository.findByName(login.getUser().getName()) != null) {
            return MessageManager.USERNAME_EXIST.label;
        } else {
            Role userRole = roleRepository.findByRoleName(UserRole.ROLE_USER.roleName);

            User userNew = new User();
            userNew.setName(login.getUser().getName());
            userNew.setPassport(login.getUser().getPassport());
            userNew.setEmail(login.getUser().getEmail());
            userNew.setUserRole(userRole);

            userRepository.save(userNew);

            User savedUser = userRepository.findByName(userNew.getName());

            Login newLogin = new Login();
            newLogin.setUser(savedUser);
            newLogin.setPassword(passwordEncoder.encode(login.getPassword()));

            loginRepository.save(newLogin);

            return MessageManager.REGISTRATION_SUCCESSFUL.label;
        }

    }

}
