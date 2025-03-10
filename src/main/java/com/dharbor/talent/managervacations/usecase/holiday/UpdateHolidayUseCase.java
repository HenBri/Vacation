package com.dharbor.talent.managervacations.usecase.holiday;

import com.dharbor.talent.managervacations.common.Message;
import com.dharbor.talent.managervacations.domain.Holiday;
import com.dharbor.talent.managervacations.domain.dto.request.HolidayRequest;
import com.dharbor.talent.managervacations.domain.dto.response.holiday.HolidayResponse;
import com.dharbor.talent.managervacations.exception.BadRequestExeption;
import com.dharbor.talent.managervacations.exception.DuplicateRegistrerException;
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
public class UpdateHolidayUseCase {
    @Autowired
    private IHolidayService holidayService;
    @Autowired
    private Message message;

    public HolidayResponse execute(HolidayRequest holidayRequest, Long idHoliday){

        validateHoliday(holidayRequest);
        try {
            Holiday holiday = holidayService.findById(idHoliday);
            Holiday holidayBuild = buildHoliday(holidayRequest);

            holiday.setDate(holidayBuild.getDate());
            holiday.setReason(holidayBuild.getReason());

            holidayService.save(holiday);
            HolidayResponse  response = buildHolidayResponse(holiday);
            return response;
        }catch (DataIntegrityViolationException exception){
            throw new DuplicateRegistrerException("Exists.holiday.message");
        }


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
    private void validateHoliday(HolidayRequest holidayRequest){
        if(Utils.isNullOrEmpty(holidayRequest.getDate())){
            throw new BadRequestExeption("NotNull.holiday.date.message");
        }if(Utils.isNullOrEmpty(holidayRequest.getReason())){
            throw new BadRequestExeption("NotNull.holiday.reason.message");
        }
    }
}
