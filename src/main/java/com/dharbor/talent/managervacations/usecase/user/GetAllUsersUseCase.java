package com.dharbor.talent.managervacations.usecase.user;

import com.dharbor.talent.managervacations.domain.User;
import com.dharbor.talent.managervacations.domain.dto.response.user.GetUsersResponse;
import com.dharbor.talent.managervacations.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Henry Aspeti
 * ShadowDevHat
 * U/J/A
 */
@Service
public class GetAllUsersUseCase {
    @Autowired
    private IUserService userService;

    public GetUsersResponse execute(){
        List<User> users = userService.getAll();
        return new GetUsersResponse(users);
    }
}
