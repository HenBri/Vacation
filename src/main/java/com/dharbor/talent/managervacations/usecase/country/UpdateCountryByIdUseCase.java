package com.dharbor.talent.managervacations.usecase.country;

import com.dharbor.talent.managervacations.domain.Country;
import com.dharbor.talent.managervacations.domain.dto.request.CountryRequest;
import com.dharbor.talent.managervacations.domain.dto.response.country.CountryResponse;
import com.dharbor.talent.managervacations.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Henry Aspeti
 * ShadowDevHat
 * U/J/A
 */
@Service
public class UpdateCountryByIdUseCase {
    @Autowired
    private ICountryService countryService;
    public CountryResponse execute(Long idCountry, CountryRequest countryRequest){
        Country country = countryService.findById(idCountry);
        country.setCode(countryRequest.getCode());
        country.setName(countryRequest.getName());

        countryService.save(country);
        return buildCountry(country);
    }
    private CountryResponse buildCountry(Country country){
        return new CountryResponse(country);
    }

}
