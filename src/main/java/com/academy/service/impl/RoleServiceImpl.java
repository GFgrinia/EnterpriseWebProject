package com.academy.service.impl;

import com.academy.model.Role;
import com.academy.repository.RoleRepository;
import com.academy.service.interfaces.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    @Override
    public Role findByName(String name) {
        return roleRepository.findByRoleName(name);
    }
}
