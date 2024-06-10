package com.dharbor.talent.managervacations.usecase.country;

import com.dharbor.talent.managervacations.domain.Country;
import com.dharbor.talent.managervacations.domain.dto.request.CountryRequest;
import com.dharbor.talent.managervacations.domain.dto.response.CountryResponse;
import com.dharbor.talent.managervacations.domain.dto.response.CountryResponseDelete;
import com.dharbor.talent.managervacations.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Henry Aspeti
 * ShadowDevHat
 * U/J/A
 */
@Service
public class DeleteCountryByIdUseCase {
    @Autowired
    private ICountryService countryService;

    public CountryResponseDelete execute(Long countryId){
        Country country = countryService.findById(countryId);
        countryService.deleteById(countryId);
        return buildCountryResponseDelete(country);
    }
    private CountryResponseDelete buildCountryResponseDelete(Country country){
        return new CountryResponseDelete(country);
    }

}
