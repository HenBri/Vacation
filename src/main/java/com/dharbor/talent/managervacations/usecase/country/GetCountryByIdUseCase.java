package com.dharbor.talent.managervacations.usecase.country;

import com.dharbor.talent.managervacations.domain.Country;
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
public class GetCountryByIdUseCase {
    @Autowired
    private ICountryService countryService;

    public CountryResponse execute(Long idCountry){
        CountryResponse buildCountry = build(idCountry);
        return buildCountry;
    }
    public CountryResponse build(Long idCountry){
        Country country = countryService.findById(idCountry);
        return new CountryResponse(country);
    }
}
