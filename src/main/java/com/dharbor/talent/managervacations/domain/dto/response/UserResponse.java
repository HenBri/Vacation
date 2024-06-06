package com.dharbor.talent.managervacations.domain.dto.response;

import com.dharbor.talent.managervacations.constant.ResponseConstant;
import com.dharbor.talent.managervacations.domain.User;
import lombok.Getter;
import lombok.Setter;
import org.apache.coyote.Response;

@Getter
@Setter
public class UserResponse extends CommonResponse{
    private User user;

    public UserResponse(User user){
        super(StatusCodeResponse.SUCCESS_CODE, StatusCodeResponse.SUCCESS_MSG);
        this.setUser(user);
    }
}
