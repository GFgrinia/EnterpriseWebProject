package com.academy.service.impl;

import com.academy.model.Role;
import com.academy.repository.LoginRepository;
import com.academy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsManager {

    private final UserRepository userRepository;
    private final LoginRepository loginRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            var user = userRepository.findByName(username);
            if (user ==  null) {
                throw new UsernameNotFoundException("User " + username + " not found.");
            }
            var password = loginRepository.findById(user.getId()).get().getPassword();

            return new User(user.getName(),
                    password,
                    true,
                    true,
                    true,
                    true,
                    getAuthorities(user));
    }


    private Collection<? extends GrantedAuthority> getAuthorities(com.academy.model.User user) {
        var authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new CarsServiceGrantedAuthority(user.getUserRole()));
        return authorities;
    }

    @Override
    public void createUser(UserDetails user) {

    }

    @Override
    public void updateUser(UserDetails user) {

    }

    @Override
    public void deleteUser(String username) {

    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    @Override
    public boolean userExists(String username) {
        return false;
    }



    public static class CarsServiceGrantedAuthority implements GrantedAuthority {

        private final Role role;

        public CarsServiceGrantedAuthority(Role role) {
            this.role = role;
        }


        public int getAuthorityValue() {
            return role.getAccessLevel();
        }

        @Override
        public String getAuthority() {
            return role.getRoleName();
        }
    }
}
