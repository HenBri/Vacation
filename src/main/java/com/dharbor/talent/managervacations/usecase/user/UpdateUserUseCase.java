package com.dharbor.talent.managervacations.usecase.user;

import com.dharbor.talent.managervacations.common.Message;
import com.dharbor.talent.managervacations.domain.User;
import com.dharbor.talent.managervacations.domain.dto.request.UserRequest;
import com.dharbor.talent.managervacations.domain.dto.response.user.UserResponse;
import com.dharbor.talent.managervacations.exception.BadRequestExeption;
import com.dharbor.talent.managervacations.service.IUserService;
import com.dharbor.talent.managervacations.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Henry Aspeti
 * ShadowDevHat
 * U/J/A
 */
@Service
public class UpdateUserUseCase {
    @Autowired
    private IUserService userService;
    @Autowired
    private Message message;

    public UserResponse execute(Long userId, UserRequest userRequest){

        User user = userService.findById(userId);
        User userBuild = buildUser(userRequest);

        user.setUserType(userBuild.getUserType());
        user.setPassword(userBuild.getPassword());
        user.setEmail(userBuild.getEmail());
        userService.save(user);
        return buildUserResponse(user);


    }

    private User buildUser(UserRequest userRequest){
        User user = new User();
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setUserType(userRequest.getType());
        return user;
    }
    private UserResponse buildUserResponse(User user){
        return new UserResponse(user);
    }
    private void userValidate(UserRequest userRequest){
        if(Utils.isNullOrEmpty(userRequest.getPassword())){
            throw new BadRequestExeption("NotNull.user.password.message");
        }if(Utils.isNullOrEmpty(userRequest.getEmail())){
            throw new BadRequestExeption("NotNull.user.email.message");
        }if(Utils.isNullOrEmpty(userRequest.getType())){
            throw new BadRequestExeption("NotNull.user.type.message");
        }
    }
}
