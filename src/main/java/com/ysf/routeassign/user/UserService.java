package com.ysf.routeassign.user;

import com.ysf.routeassign.user.dtos.GetUserResponseDTO;
import com.ysf.routeassign.user.dtos.RegisterUserRequestDTO;
import com.ysf.routeassign.user.dtos.UpdateUserRequestDTO;
import com.ysf.routeassign.user.dtos.mappers.GetUserResponseDTOMapper;
import com.ysf.routeassign.user.dtos.mappers.RegisterUserRequestDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final GetUserResponseDTOMapper getUserResponseDTOMapper;
    private final RegisterUserRequestDTOMapper registerUserRequestDTOMapper;
    private final BCryptPasswordEncoder encoder;

    public List<GetUserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream().map(getUserResponseDTOMapper).collect(Collectors.toList());
    }

    public GetUserResponseDTO getUser(Long id) {
        return getUserResponseDTOMapper.apply(userRepository.findById(id).orElseThrow());
    }

    public GetUserResponseDTO registerUser(RegisterUserRequestDTO userDTO){

        UserDAO userDAO = registerUserRequestDTOMapper.apply(userDTO);
        userDAO.setPassword(encoder.encode(userDAO.getPassword()));

        return getUserResponseDTOMapper.apply(userRepository.save(userDAO));
    }

    public GetUserResponseDTO updateUser(Long id, UpdateUserRequestDTO userUpdateRequestDTO){
        UserDAO user = userRepository.findById(id).orElseThrow();

        if(userUpdateRequestDTO.role() != null){
            user.setRole(Role.valueOf(userUpdateRequestDTO.role()));
        }

        return getUserResponseDTOMapper.apply(userRepository.save(user));
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }


}
