package com.dharbor.talent.managervacations.domain.dto.response.vacation;

import com.dharbor.talent.managervacations.domain.Vacation;
import com.dharbor.talent.managervacations.domain.dto.response.CommonResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Henry Aspeti
 * ShadowDevHat
 * U/J/A
 */
@Getter
@Setter
public class GetVacationsResponse extends CommonResponse {
    private List<Vacation> vacations;

    public GetVacationsResponse(List<Vacation> vacations){
        super(StatusCodeResponse.SUCCESS_CODE, StatusCodeResponse.SUCCESS_MSG);
        this.vacations = vacations;
    }
}

