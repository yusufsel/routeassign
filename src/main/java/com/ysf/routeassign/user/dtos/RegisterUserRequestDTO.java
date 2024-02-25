package com.ysf.routeassign.user.dtos;

public record RegisterUserRequestDTO(
        String username,
        String password,
        String role
) {
}
