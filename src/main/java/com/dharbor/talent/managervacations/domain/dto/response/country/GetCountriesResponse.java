package com.dharbor.talent.managervacations.domain.dto.response.country;

import com.dharbor.talent.managervacations.constant.ResponseConstant;
import com.dharbor.talent.managervacations.domain.Country;
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
public class GetCountriesResponse extends CommonResponse {
    private List<Country> country;

    public GetCountriesResponse(List<Country> country) {
        super(ResponseConstant.StatusCodeResponse.SUCCESS_CODE, ResponseConstant.StatusCodeResponse.SUCCESS_MSG);
        this.country = country;
    }
}
