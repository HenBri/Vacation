package com.dharbor.talent.managervacations.usecase;

import com.dharbor.talent.managervacations.domain.User;
import com.dharbor.talent.managervacations.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetUserByIdUseCase {
    @Autowired
    private IUserService userService;

    public List<User> execute(){
        List<User> users = userService.getAll();
        return users;
    }
}
