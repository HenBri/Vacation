package com.dharbor.talent.managervacations.domain.dto.request;

import com.dharbor.talent.managervacations.domain.UserType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    private String email;
    private String password;
    private UserType type;
}
