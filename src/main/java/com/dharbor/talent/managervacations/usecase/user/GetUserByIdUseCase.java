package com.dharbor.talent.managervacations.usecase.user;

import com.dharbor.talent.managervacations.domain.User;
import com.dharbor.talent.managervacations.domain.dto.response.user.UserResponse;
import com.dharbor.talent.managervacations.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
