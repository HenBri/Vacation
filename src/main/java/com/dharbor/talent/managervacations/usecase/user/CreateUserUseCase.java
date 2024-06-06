package com.dharbor.talent.managervacations.usecase.user;

import com.dharbor.talent.managervacations.domain.User;
import com.dharbor.talent.managervacations.domain.dto.request.UserRequest;
import com.dharbor.talent.managervacations.domain.dto.response.UserResponse;
import com.dharbor.talent.managervacations.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CreateUserUseCase {

    @Autowired
    private IUserService userService;


    public UserResponse execute(UserRequest userRequest){
        User userBuild = buildUser(userRequest);
        userService.save(userBuild);
        return  buildUserResponse(userBuild);
    }
    public User buildUser(UserRequest userRequest){
        User user = new User();
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setUserType(userRequest.getType());
        return user;
    }

    private UserResponse buildUserResponse(User user){
        return new UserResponse(user);
    }

}
