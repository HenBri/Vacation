package com.dharbor.talent.managervacations.usecase.holiday;

import com.dharbor.talent.managervacations.common.Message;
import com.dharbor.talent.managervacations.domain.Country;
import com.dharbor.talent.managervacations.domain.Holiday;
import com.dharbor.talent.managervacations.domain.dto.request.HolidayRequest;
import com.dharbor.talent.managervacations.domain.dto.response.holiday.HolidayResponse;
import com.dharbor.talent.managervacations.exception.BadRequestExeption;
import com.dharbor.talent.managervacations.exception.DuplicateRegistrerException;
import com.dharbor.talent.managervacations.service.ICountryService;
import com.dharbor.talent.managervacations.service.IHolidayService;
import com.dharbor.talent.managervacations.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
    @Autowired
    private Message message;

    public HolidayResponse execute(HolidayRequest holidayRequest, Long idCountry){

        validateHoliday(holidayRequest);
        try {
            Country country = countryService.findById(idCountry);
            return buildHolidayResponse(
                    holidayService.save(
                            buildHoliday(holidayRequest,country)));

        }catch (DataIntegrityViolationException exception){
            throw new DuplicateRegistrerException(message.getMessage("Exists.team.name.message"));
        }



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
    private void validateHoliday(HolidayRequest holidayRequest){
        if (Utils.isNullOrEmpty(holidayRequest.getReason())) {
            throw new BadRequestExeption(message.getMessage("NotNull.holiday.reason.message"));
        }
        if (Utils.isNullOrEmpty(holidayRequest.getDate())) {
            throw new BadRequestExeption(message.getMessage("NotNull.holiday.date.message"));
        }

    }
}
