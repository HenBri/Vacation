package com.dharbor.talent.managervacations.domain.dto.response;

import com.dharbor.talent.managervacations.domain.Country;
import com.dharbor.talent.managervacations.domain.dto.request.CountryRequest;
import com.mysql.cj.Constants;
import com.mysql.cj.exceptions.CJOperationNotSupportedException;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Henry Aspeti
 * ShadowDevHat
 * U/J/A
 */
@Getter
@Setter
public class CountryResponse extends CommonResponse{
    private Country country;

    public CountryResponse(Country country) {
        super(StatusCodeResponse.SUCCESS_CODE, StatusCodeResponse.SUCCESS_MSG);
        this.country = country;
    }
}
