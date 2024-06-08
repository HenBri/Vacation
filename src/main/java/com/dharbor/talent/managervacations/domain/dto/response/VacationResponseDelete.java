package com.dharbor.talent.managervacations.domain.dto.response;

import com.dharbor.talent.managervacations.domain.User;
import com.dharbor.talent.managervacations.domain.Vacation;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Henry Aspeti
 * ShadowDevHat
 * U/J/A
 */
@Getter
@Setter
public class VacationResponseDelete extends CommonResponse{
    private Vacation vacation;
    public VacationResponseDelete(Vacation vacation) {
        super(DeleteCodeResponse.SUCCESS_CODE, DeleteCodeResponse.SUCCESS_MSG);
        this.vacation=vacation;
    }
}
