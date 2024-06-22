package com.dharbor.talent.managervacations.usecase.holiday;

import com.dharbor.talent.managervacations.domain.Country;
import com.dharbor.talent.managervacations.domain.Holiday;
import com.dharbor.talent.managervacations.domain.dto.response.holiday.GetHolidaysResponseDelete;
import com.dharbor.talent.managervacations.service.ICountryService;
import com.dharbor.talent.managervacations.service.IHolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Henry Aspeti
 * ShadowDevHat
 * U/J/A
 */
@Service
public class DeleteAllHolidayByCountryUseCase {
    @Autowired
    private IHolidayService holidayService;
    @Autowired
    private ICountryService countryService;

    @Transactional
    public GetHolidaysResponseDelete execute(Long idCountry){
        Country country = countryService.findById(idCountry);
        GetHolidaysResponseDelete buildHoliday = build(country);

        holidayService.deleteAllByCountry(country);
        return buildHoliday;

    }
    private GetHolidaysResponseDelete build(Country country) {
        List<Holiday> holidays = holidayService.getHolidayByCountry(country);
        return new GetHolidaysResponseDelete(holidays);
    }
}
