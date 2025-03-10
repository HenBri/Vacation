package com.dharbor.talent.managervacations.controller;


import com.dharbor.talent.managervacations.domain.dto.request.UserRequest;
import com.dharbor.talent.managervacations.domain.dto.response.user.GetUsersResponse;
import com.dharbor.talent.managervacations.domain.dto.response.user.UserResponse;
import com.dharbor.talent.managervacations.domain.dto.response.user.UserResponseDelete;
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
    @Autowired
    private DeleteAllUsersByCountryUseCase deleteAllUsersByCountryUseCase;

    @PostMapping("/Create")
    public UserResponse saveUser(@RequestBody UserRequest user, @RequestParam List<Long> countryIds) {
        return createUserUseCase.execute(user, countryIds);
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
    public GetUsersResponse getAllUsers() {
        return getAllUsers.execute();
    }

    @DeleteMapping("DeleteByCountry/{countryId}")
    public GetUsersResponse deleteByCopuntry(@PathVariable Long countryId){
        return deleteAllUsersByCountryUseCase.execute(countryId);
    }
}
