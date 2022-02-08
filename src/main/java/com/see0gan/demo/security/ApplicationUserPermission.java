package com.see0gan.demo.security;

public enum ApplicationUserPermission {
    SPACE_READ("space:read"),
    SPACE_WRITE("space:write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
