package com.dharbor.talent.managervacations.controller;


import com.dharbor.talent.managervacations.domain.User;
import com.dharbor.talent.managervacations.usecase.CreateUserUseCase;
import com.dharbor.talent.managervacations.usecase.GetUserByIdUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Users")
public class UserController {
    @Autowired
    private CreateUserUseCase createUserUseCase;
    @Autowired
    private GetUserByIdUseCase getUserByIdUseCase;

    @PostMapping("Create")
    public User saveUser(@RequestBody User user){
        return createUserUseCase.execute(user);
    }
    @GetMapping("getById")
    public List<User> getUserById() {
        return getUserByIdUseCase.execute();
    }
}
