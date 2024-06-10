package com.dharbor.talent.managervacations.usecase.country;

import com.dharbor.talent.managervacations.domain.Country;
import com.dharbor.talent.managervacations.domain.dto.response.CountryResponse;
import com.dharbor.talent.managervacations.domain.dto.response.GetCountriesResponse;
import com.dharbor.talent.managervacations.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Henry Aspeti
 * ShadowDevHat
 * U/J/A
 */
@Service
public class GetAllCountriesUseCase {
    @Autowired
    private ICountryService countryService;

    public GetCountriesResponse execute(){
        List<Country> countries = countryService.getAll();
        GetCountriesResponse countriesResponse = buildCountries(countries);
        return countriesResponse;
    }
    private GetCountriesResponse buildCountries(List<Country> countries){
        return new GetCountriesResponse(countries);
    }

}
