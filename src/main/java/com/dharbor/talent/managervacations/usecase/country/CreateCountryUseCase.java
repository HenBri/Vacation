package com.dharbor.talent.managervacations.usecase.country;

import com.dharbor.talent.managervacations.domain.Country;
import com.dharbor.talent.managervacations.domain.dto.request.CountryRequest;
import com.dharbor.talent.managervacations.domain.dto.response.CountryResponse;
import com.dharbor.talent.managervacations.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Henry Aspeti
 * ShadowDevHat
 * U/J/A
 */
@Service
public class CreateCountryUseCase {
    @Autowired
    private ICountryService countryService;

    public CountryResponse execute(CountryRequest countryRequest){
        Country country = buildCountry(countryRequest);
        countryService.save(country);
        CountryResponse countryResponse = buildCountryResponse(country);
        return countryResponse;
    }
    public Country buildCountry(CountryRequest countryRequest){
        Country country = new Country();
        country.setCode(countryRequest.getCode());
        country.setName(countryRequest.getName());
        return country;
    }
    private CountryResponse buildCountryResponse(Country country){
       return new CountryResponse(country);
    }
}
