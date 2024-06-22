package com.dharbor.talent.managervacations.usecase.holiday;

import com.dharbor.talent.managervacations.domain.Country;
import com.dharbor.talent.managervacations.domain.Holiday;
import com.dharbor.talent.managervacations.domain.dto.response.holiday.GetHolidaysResponse;
import com.dharbor.talent.managervacations.service.ICountryService;
import com.dharbor.talent.managervacations.service.IHolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Henry Aspeti
 * ShadowDevHat
 * U/J/A
 */
@Service
public class GetHolidayByCountryUseCase {
    @Autowired
    private IHolidayService holidayService;
    @Autowired
    private ICountryService countryService;

    public GetHolidaysResponse execute(Long idCountry){
        Country country = countryService.findById(idCountry);
        GetHolidaysResponse holidays = build(country);
        return holidays;
    }
    private GetHolidaysResponse build(Country country){
        List<Holiday> holidays = holidayService.getHolidayByCountry(country);
        return new GetHolidaysResponse(holidays);
    }
}
