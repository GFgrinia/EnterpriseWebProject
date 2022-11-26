package com.academy.service.interfaces;

import com.academy.model.Role;

public interface RoleService {
    Role findByName(String name);
}
