package com.dharbor.talent.managervacations.controller;


import com.dharbor.talent.managervacations.domain.User;
import com.dharbor.talent.managervacations.domain.dto.request.UserRequest;
import com.dharbor.talent.managervacations.domain.dto.response.UserResponse;
import com.dharbor.talent.managervacations.domain.dto.response.UserResponseDelete;
import com.dharbor.talent.managervacations.usecase.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Users")
public class UserController {
    @Autowired
    private CreateUserUseCase createUserUseCase;
    @Autowired
    private GetAllUsersUseCase getAllUsers;
    @Autowired
    private GetUserByIdUseCase getUserByIdUseCase;
    @Autowired
    private DeleteUserByIdUseCase deleteUserUseCase;
    @Autowired
    private UpdateUserUseCase updateUserUseCase;

    @PostMapping("Create")
    public UserResponse saveUser(@RequestBody UserRequest user){
        return createUserUseCase.execute(user);
    }
    @GetMapping("GetUserById/{userId}")
    public UserResponse getUserById(@PathVariable Long userId){
        return getUserByIdUseCase.execute(userId);
    }
    @PutMapping("UpdateUserById/{userId}")
    public UserResponse updateUserById(@RequestBody UserRequest user, @PathVariable Long userId){
        return updateUserUseCase.execute(userId, user);
    }


    @DeleteMapping("DeleteUser/{userId}")
    public UserResponseDelete deleteUserById(@PathVariable Long userId){
        return deleteUserUseCase.execute(userId);
    }

    @GetMapping("GetAll")
    public List<User> getAllUsers() {
        return getAllUsers.execute();
    }
}
