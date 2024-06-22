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
public class GetVacationsResponseDelete extends CommonResponse {
    private List<Vacation> vacations;

    public GetVacationsResponseDelete(List<Vacation> vacations){
        super(DeleteCodeResponse.SUCCESS_CODE, DeleteCodeResponse.SUCCESS_MSG);
        this.vacations = vacations;
    }
}
