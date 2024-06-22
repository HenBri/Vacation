package com.dharbor.talent.managervacations.domain.dto.response.vacation;

import com.dharbor.talent.managervacations.domain.Vacation;
import com.dharbor.talent.managervacations.domain.dto.response.CommonResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VacationResponse extends CommonResponse {
    private Vacation vacation;

    public VacationResponse(Vacation vacation){
        super(StatusCodeResponse.SUCCESS_CODE, StatusCodeResponse.SUCCESS_MSG);
        this.vacation=vacation;
    }

}
