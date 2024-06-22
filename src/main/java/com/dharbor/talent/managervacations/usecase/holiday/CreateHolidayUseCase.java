package com.dharbor.talent.managervacations.usecase.holiday;

import com.dharbor.talent.managervacations.domain.Country;
import com.dharbor.talent.managervacations.domain.Holiday;
import com.dharbor.talent.managervacations.domain.dto.request.HolidayRequest;
import com.dharbor.talent.managervacations.domain.dto.response.holiday.HolidayResponse;
import com.dharbor.talent.managervacations.service.ICountryService;
import com.dharbor.talent.managervacations.service.IHolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Henry Aspeti
 * ShadowDevHat
 * U/J/A
 */
@Service
public class CreateHolidayUseCase {
    @Autowired
    private IHolidayService holidayService;
    @Autowired
    private ICountryService countryService;

    public HolidayResponse execute(HolidayRequest holidayRequest, Long idCountry){
        Country country = countryService.findById(idCountry);
        Holiday holiday = buildHoliday(holidayRequest, country);
        holidayService.save(holiday);
        HolidayResponse holidayResponse = buildHolidayResponse(holiday);
        return holidayResponse;
    }
    private Holiday buildHoliday(HolidayRequest holidayRequest, Country country){
        Holiday holiday = new Holiday();
        holiday.setDate(holidayRequest.getDate());
        holiday.setReason(holidayRequest.getReason());
        holiday.setCountry(country);
        return holiday;
    }
    private HolidayResponse buildHolidayResponse(Holiday holiday){
        return new HolidayResponse(holiday);
    }
}
