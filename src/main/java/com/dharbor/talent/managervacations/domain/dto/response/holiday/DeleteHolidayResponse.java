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
public class DeleteHolidayResponse extends CommonResponse {
    private Holiday holiday;
    public DeleteHolidayResponse(Holiday holiday){
        super(DeleteCodeResponse.SUCCESS_CODE, DeleteCodeResponse.SUCCESS_MSG);
        this.holiday = holiday;
    }
}
