package com.dharbor.talent.managervacations.domain.dto.response.country;

import com.dharbor.talent.managervacations.constant.ResponseConstant;
import com.dharbor.talent.managervacations.domain.Country;
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
public class CountryResponseDelete extends CommonResponse {
    private Country country;

    public CountryResponseDelete(Country country) {
        super(ResponseConstant.DeleteCodeResponse.SUCCESS_CODE, ResponseConstant.DeleteCodeResponse.SUCCESS_MSG);
        this.country = country;
    }
}
