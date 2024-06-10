package com.dharbor.talent.managervacations.controller;

import com.dharbor.talent.managervacations.domain.dto.request.CountryRequest;
import com.dharbor.talent.managervacations.domain.dto.response.CountryResponse;
import com.dharbor.talent.managervacations.domain.dto.response.CountryResponseDelete;
import com.dharbor.talent.managervacations.domain.dto.response.GetCountriesResponse;
import com.dharbor.talent.managervacations.usecase.country.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Henry Aspeti
 * ShadowDevHat
 * U/J/A
 */
@RestController
@RequestMapping("/Countries")
public class CountryController {
    @Autowired
    private CreateCountryUseCase createCountryUseCase;
    @Autowired
    private GetAllCountriesUseCase getAllCountriesUseCase;
    @Autowired
    private DeleteCountryByIdUseCase deleteCountryByIdUseCase;
    @Autowired
    private GetCountryByIdUseCase getCountryByIdUseCase;
    @Autowired
    private UpdateCountryByIdUseCase updateCountryByIdUseCase;

    @PostMapping("Create")
    public CountryResponse saveCountry(@RequestBody CountryRequest countryRequest){
        return createCountryUseCase.execute(countryRequest);
    }
    @GetMapping("/GetAll")
    public GetCountriesResponse getAllCountries(){
        return getAllCountriesUseCase.execute();
    }
    @DeleteMapping("/{idCountry}")
    public CountryResponseDelete deleteCountryById(@PathVariable Long idCountry){
        return deleteCountryByIdUseCase.execute(idCountry);
    }
    @GetMapping("/{idCountry}")
    public CountryResponse getCountryById(@PathVariable Long idCountry){
        return getCountryByIdUseCase.execute(idCountry);
    }
    @PutMapping("/{idCountry}")
    public CountryResponse updateCountryById(@RequestBody CountryRequest countryRequest, @PathVariable Long idCountry){
        return  updateCountryByIdUseCase.execute(idCountry,countryRequest);
    }

}
