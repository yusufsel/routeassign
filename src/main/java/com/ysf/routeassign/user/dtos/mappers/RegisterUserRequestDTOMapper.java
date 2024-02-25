package com.ysf.routeassign.user.dtos.mappers;

import com.ysf.routeassign.user.Role;
import com.ysf.routeassign.user.UserDAO;
import com.ysf.routeassign.user.dtos.RegisterUserRequestDTO;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class RegisterUserRequestDTOMapper implements Function<RegisterUserRequestDTO, UserDAO> {
    @Override
    public UserDAO apply(RegisterUserRequestDTO userRegisterRequestDTO) {
        return new UserDAO(null,userRegisterRequestDTO.username(),userRegisterRequestDTO.password(), Role.valueOf(userRegisterRequestDTO.role()));
    }
}
