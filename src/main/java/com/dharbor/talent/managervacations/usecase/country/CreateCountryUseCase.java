package com.dharbor.talent.managervacations.usecase.country;

import com.dharbor.talent.managervacations.common.Message;
import com.dharbor.talent.managervacations.domain.Country;
import com.dharbor.talent.managervacations.domain.dto.request.CountryRequest;
import com.dharbor.talent.managervacations.domain.dto.response.country.CountryResponse;
import com.dharbor.talent.managervacations.exception.BadRequestExeption;
import com.dharbor.talent.managervacations.exception.DuplicateRegistrerException;
import com.dharbor.talent.managervacations.service.ICountryService;
import com.dharbor.talent.managervacations.utils.Utils;
import jdk.jshell.execution.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
    @Autowired
    private Message message;

    public CountryResponse execute(CountryRequest countryRequest){
        validateCountry(countryRequest);

        try {
            return buildCountryResponse(
                    countryService.save(
                            buildCountry(countryRequest)
                    )
            );
        }catch (DataIntegrityViolationException ex){
            throw new DuplicateRegistrerException(message.getMessage("Exists.country.code.message"));
        }

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

    private void validateCountry(CountryRequest countryRequest){
        if (Utils.isNullOrEmpty(countryRequest.getName())) {
            throw new BadRequestExeption(message.getMessage("NotNull.country.name.message"));
        }
        if (Utils.isNullOrEmpty(countryRequest.getCode())) {
            throw new BadRequestExeption(message.getMessage("NotNull.country.code.message"));
        }
    }
}
