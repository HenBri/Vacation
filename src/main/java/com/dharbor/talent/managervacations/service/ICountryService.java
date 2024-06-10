package com.dharbor.talent.managervacations.service;

import com.dharbor.talent.managervacations.domain.Country;
import com.dharbor.talent.managervacations.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Henry Aspeti
 * ShadowDevHat
 * U/J/A
 */
public interface ICountryService {
  Country save(Country country);
  List<Country> getAll();
  Country findById(Long countryId);
  void deleteById(Long countryId);
}
