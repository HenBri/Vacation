package com.dharbor.talent.managervacations.domain.dto.response;

import com.dharbor.talent.managervacations.domain.Vacation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VacationResponse extends CommonResponse{
    private Vacation vacation;

    public VacationResponse(Vacation vacation){
        super(StatusCodeResponse.SUCCESS_CODE, StatusCodeResponse.SUCCESS_MSG);
        this.vacation=vacation;
    }

}
