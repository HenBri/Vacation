package com.dharbor.talent.managervacations.usecase.user;

import com.dharbor.talent.managervacations.domain.User;
import com.dharbor.talent.managervacations.domain.dto.response.UserResponse;
import com.dharbor.talent.managervacations.service.IUserService;
import com.dharbor.talent.managervacations.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetUserByIdUseCase {
    @Autowired
    private IUserService iUserService;

    public UserResponse execute(Long idUser) {
        User user =  iUserService.findById(idUser);
        UserResponse userResponse = buildUser(user);
        return userResponse;
    }

    public UserResponse buildUser(User user){
        return new UserResponse(user);
    }

}
