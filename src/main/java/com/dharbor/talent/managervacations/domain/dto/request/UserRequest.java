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

    public boolean emailIsValid(String email){
        return email == null || email.isEmpty();
    }
    public boolean passwordIsValid(String password){
        return password == null || password.isEmpty();
    }
    public boolean typeIsValid(UserType type){
        return type == null;
    }

}
