package com.dharbor.talent.managervacations.service;

import com.dharbor.talent.managervacations.domain.Country;
import com.dharbor.talent.managervacations.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Henry Aspeti
 * ShadowDevHat
 * U/J/A
 */
@Service
public class CountryServiceImpl implements ICountryService{
    @Autowired
    private CountryRepository countryRepository;
    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country findById(Long countryId) {
        return countryRepository.getById(countryId);
    }

    @Override
    public void deleteById(Long countryId) {
        countryRepository.deleteById(countryId);
    }
}
