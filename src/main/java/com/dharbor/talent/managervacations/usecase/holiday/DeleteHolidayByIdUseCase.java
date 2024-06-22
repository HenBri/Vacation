package com.dharbor.talent.managervacations.usecase.holiday;

import com.dharbor.talent.managervacations.domain.Holiday;
import com.dharbor.talent.managervacations.domain.dto.response.holiday.DeleteHolidayResponse;
import com.dharbor.talent.managervacations.service.IHolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Henry Aspeti
 * ShadowDevHat
 * U/J/A
 */
@Service
public class DeleteHolidayByIdUseCase {
    @Autowired
    private IHolidayService holidayService;

    public DeleteHolidayResponse execute(Long idHoliday){
        Holiday holiday = holidayService.findById(idHoliday);
        DeleteHolidayResponse build = build(holiday);

        holidayService.deleteById(idHoliday);
        return build;

    }
    private DeleteHolidayResponse build(Holiday holiday){
        return new DeleteHolidayResponse(holiday);
    }
}
