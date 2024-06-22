package com.dharbor.talent.managervacations.service;

import com.dharbor.talent.managervacations.domain.Country;
import com.dharbor.talent.managervacations.domain.Holiday;

import java.util.List;

/**
 * @author Henry Aspeti
 * ShadowDevHat
 * U/J/A
 */
public interface IHolidayService {
    List<Holiday> getAll();
    List<Holiday> getHolidayByCountry(Country country);
    Holiday findById(Long idHoliday);
    void deleteById(Long idHoliday);
    Holiday save(Holiday holiday);
    void deleteAllByCountry(Country country);

}
