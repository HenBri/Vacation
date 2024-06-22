package com.dharbor.talent.managervacations.usecase.user;

import com.dharbor.talent.managervacations.domain.User;
import com.dharbor.talent.managervacations.domain.dto.response.user.UserResponseDelete;
import com.dharbor.talent.managervacations.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Henry Aspeti
 * ShadowDevHat
 * U/J/A
 */
@Service
public class DeleteUserByIdUseCase {
    @Autowired
    private IUserService userService;

    public UserResponseDelete execute(Long userId){

        UserResponseDelete userBuild = buildUser(userId);
        userService.deleteById(userId);
        return userBuild;
    }
    public UserResponseDelete buildUser(Long userId){
        User user = userService.findById(userId);
        return new UserResponseDelete(user);
    }

}

