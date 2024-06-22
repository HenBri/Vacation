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
public class GetHolidaysResponseDelete extends CommonResponse {
    private List<Holiday> holidays;
    public GetHolidaysResponseDelete(List<Holiday> holidays){
        super(DeleteCodeResponse.SUCCESS_CODE, DeleteCodeResponse.SUCCESS_MSG);
        this.holidays = holidays;
    }
}
