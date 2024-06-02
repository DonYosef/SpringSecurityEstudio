package com.app.controller.dto;

public record AuthRegisterRequest(
        String username,
        String password,
        AuthCreateRoleRequest authCreateRoleRequest
) {
}
