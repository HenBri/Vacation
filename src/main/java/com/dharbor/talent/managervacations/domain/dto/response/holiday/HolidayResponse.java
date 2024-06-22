package com.dharbor.talent.managervacations.domain.dto.response.holiday;

import com.dharbor.talent.managervacations.domain.Holiday;
import com.dharbor.talent.managervacations.domain.dto.response.CommonResponse;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Henry Aspeti
 * ShadowDevHat
 * U/J/A
 */
@Getter
@Setter
public class HolidayResponse extends CommonResponse {
    private Holiday holiday;
    public HolidayResponse(Holiday holiday){
        super(StatusCodeResponse.SUCCESS_CODE, StatusCodeResponse.SUCCESS_MSG);
        this.holiday = holiday;
    }
}
