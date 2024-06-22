package com.dharbor.talent.managervacations.domain.dto.response.holiday;

import com.dharbor.talent.managervacations.constant.ResponseConstant;
import com.dharbor.talent.managervacations.domain.Holiday;
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
public class GetHolidaysResponse extends CommonResponse {
    private List<Holiday> holidays;
    public GetHolidaysResponse(List<Holiday> holidays){
        super(ResponseConstant.StatusCodeResponse.SUCCESS_CODE, ResponseConstant.StatusCodeResponse.SUCCESS_MSG);
        this.holidays = holidays;
    }
}
