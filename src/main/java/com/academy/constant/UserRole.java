package com.academy.constant;

public enum UserRole {

    ROLE_USER("ROLE_USER",1),
    ROLE_ADMIN("ROLE_ADMIN",5);

    public final String roleName;
    public final int accessLevel;



    UserRole(String roleName, int accessLevel) {
        this.roleName = roleName;
        this.accessLevel = accessLevel;
    }
}
