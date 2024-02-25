package com.ysf.routeassign.user.dtos.mappers;

import com.ysf.routeassign.user.UserDAO;
import com.ysf.routeassign.user.dtos.GetUserResponseDTO;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class GetUserResponseDTOMapper implements Function<UserDAO, GetUserResponseDTO> {
    @Override
    public GetUserResponseDTO apply(UserDAO userDAO) {
        return new GetUserResponseDTO(
                userDAO.getId(),
                userDAO.getUsername(),
                userDAO.getRole().name()
        );
    }
}
