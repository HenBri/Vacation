package com.dharbor.talent.managervacations.usecase.holiday;

import com.dharbor.talent.managervacations.domain.Holiday;
import com.dharbor.talent.managervacations.domain.dto.request.HolidayRequest;
import com.dharbor.talent.managervacations.domain.dto.response.holiday.HolidayResponse;
import com.dharbor.talent.managervacations.service.IHolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Henry Aspeti
 * ShadowDevHat
 * U/J/A
 */
@Service
public class UpdateHolidayUseCase {
    @Autowired
    private IHolidayService holidayService;

    public HolidayResponse execute(HolidayRequest holidayRequest, Long idHoliday){
        Holiday holiday = holidayService.findById(idHoliday);
        Holiday holidayBuild = buildHoliday(holidayRequest);

        holiday.setDate(holidayBuild.getDate());
        holiday.setReason(holidayBuild.getReason());

        holidayService.save(holiday);
        HolidayResponse  response = buildHolidayResponse(holiday);
        return response;

    }
    private Holiday buildHoliday(HolidayRequest holidayRequest){
        Holiday holiday = new Holiday();
        holiday.setDate(holidayRequest.getDate());
        holiday.setReason(holidayRequest.getReason());
        return holiday;
    }
    private HolidayResponse buildHolidayResponse(Holiday holiday){
        return new HolidayResponse(holiday);
    }
}
