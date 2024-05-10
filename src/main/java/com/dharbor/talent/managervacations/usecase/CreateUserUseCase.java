package com.dharbor.talent.managervacations.usecase;

import com.dharbor.talent.managervacations.domain.User;
import com.dharbor.talent.managervacations.domain.dto.request.UserRequest;
import com.dharbor.talent.managervacations.repository.UserRepository;
import com.dharbor.talent.managervacations.service.IUserService;
import com.dharbor.talent.managervacations.service.IVacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCase {

    @Autowired
    private IUserService userService;


    public User execute(User user){
       // User user = new User();

       /* user.setId();
        user.setCreateDate(userRequest.getCreateDate());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        */return buildUser(user);
    }
    public User buildUser(User user){
        return userService.save(user);
    }

}
