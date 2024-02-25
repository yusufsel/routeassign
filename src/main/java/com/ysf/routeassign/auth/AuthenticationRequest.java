package com.ysf.routeassign.auth;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AuthenticationRequest(
        @NotBlank(message = "username is mandatory")
        @Size(min = 5,max = 255)
        String username,
        @NotBlank(message = "password is mandatory")
        @Size(min = 5,max = 255)
        String password
) {
}
