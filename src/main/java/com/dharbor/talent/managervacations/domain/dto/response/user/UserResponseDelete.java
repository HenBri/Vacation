package com.dharbor.talent.managervacations.domain.dto.response.user;

import com.dharbor.talent.managervacations.domain.User;
import com.dharbor.talent.managervacations.domain.dto.response.CommonResponse;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Henry Aspeti
 * ShadowDevHat
 * U/J/A
 */
@Setter
@Getter
public class UserResponseDelete extends CommonResponse {
    private User user;
    public UserResponseDelete(User user) {
        super(DeleteCodeResponse.SUCCESS_CODE, DeleteCodeResponse.SUCCESS_MSG);
        this.user=user;
    }
}
