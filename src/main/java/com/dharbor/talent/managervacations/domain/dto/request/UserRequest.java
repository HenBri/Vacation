package com.dharbor.talent.managervacations.domain.dto.request;

import com.dharbor.talent.managervacations.domain.UserType;
import com.dharbor.talent.managervacations.domain.dto.response.UserResponse;
import com.dharbor.talent.managervacations.domain.dto.response.UserResponseDelete;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class UserRequest {
    private String email;
    private String password;
    private UserType type;
}
