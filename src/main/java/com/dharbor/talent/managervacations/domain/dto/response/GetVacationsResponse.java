package com.dharbor.talent.managervacations.domain.dto.response;

import com.dharbor.talent.managervacations.domain.User;
import com.dharbor.talent.managervacations.domain.Vacation;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Henry Aspeti
 * ShadowDevHat
 * U/J/A
 */
@Getter
@Setter
public class GetVacationsResponse extends CommonResponse{
    private List<Vacation> vacations;

    public GetVacationsResponse(List<Vacation> vacations){
        super(StatusCodeResponse.SUCCESS_CODE, StatusCodeResponse.SUCCESS_MSG);
        this.vacations = vacations;
    }
}

