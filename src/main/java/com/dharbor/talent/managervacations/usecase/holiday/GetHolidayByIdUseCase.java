package com.dharbor.talent.managervacations.usecase.holiday;

import com.dharbor.talent.managervacations.domain.Holiday;
import com.dharbor.talent.managervacations.domain.dto.response.holiday.HolidayResponse;
import com.dharbor.talent.managervacations.service.IHolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.stereotype.Service;

/**
 * @author Henry Aspeti
 * ShadowDevHat
 * U/J/A
 */
@Service
public class GetHolidayByIdUseCase {
    @Autowired
    private IHolidayService holidayService;

    public HolidayResponse execute(Long idHoliday){
        Holiday holiday = holidayService.findById(idHoliday);
        HolidayResponse build= build(holiday);
        return build;
    }

    private HolidayResponse build(Holiday holiday){
        return new HolidayResponse(holiday);
    }
}
