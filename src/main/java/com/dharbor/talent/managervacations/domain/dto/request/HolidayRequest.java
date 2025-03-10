package com.dharbor.talent.managervacations.domain.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Henry Aspeti
 * ShadowDevHat
 * U/J/A
 */
@Getter
@Setter
public class HolidayRequest {
    private String reason;
    private Date date;

    public boolean reasonIsValid(String reason){
        return reason == null || reason.isEmpty();
    }
    public boolean dateIsValid(Date date){
        return date == null ;
    }
}
