package com.dharbor.talent.managervacations.domain.dto.response;

import com.dharbor.talent.managervacations.constant.ResponseConstant;
import com.dharbor.talent.managervacations.domain.Vacation;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

/**
 * @author Henry Aspeti
 * ShadowDevHat
 * U/J/A
 */
@Getter
@Setter
public class GetVacationsResponseDelete extends CommonResponse{
    private List<Vacation> vacations;

    public GetVacationsResponseDelete(List<Vacation> vacations){
        super(DeleteCodeResponse.SUCCESS_CODE, DeleteCodeResponse.SUCCESS_MSG);
        this.vacations = vacations;
    }
}
