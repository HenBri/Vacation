package com.dharbor.talent.managervacations.domain.dto.response.user;

import com.dharbor.talent.managervacations.domain.User;
import com.dharbor.talent.managervacations.domain.dto.response.CommonResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse extends CommonResponse {
    private User user;

    public UserResponse(User user){
        super(StatusCodeResponse.SUCCESS_CODE, StatusCodeResponse.SUCCESS_MSG);
        this.setUser(user);
    }
}
