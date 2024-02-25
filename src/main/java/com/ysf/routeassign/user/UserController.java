package com.ysf.routeassign.user;


import com.ysf.routeassign.user.dtos.GetUserResponseDTO;
import com.ysf.routeassign.user.dtos.RegisterUserRequestDTO;
import com.ysf.routeassign.user.dtos.UpdateUserRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;


    @GetMapping(path = "{id}")
    public ResponseEntity<GetUserResponseDTO> findUser(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUser(id));
    }

    @GetMapping
    public ResponseEntity<List<GetUserResponseDTO>> findAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping
    public ResponseEntity<GetUserResponseDTO> registerUser(@RequestBody RegisterUserRequestDTO userRegisterRequestDTO){
        return ResponseEntity.ok(userService.registerUser(userRegisterRequestDTO));
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<GetUserResponseDTO> updateUser(@PathVariable Long id, @RequestBody UpdateUserRequestDTO userUpdateRequestDTO){
        return ResponseEntity.ok(userService.updateUser(id,userUpdateRequestDTO));
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }



}
