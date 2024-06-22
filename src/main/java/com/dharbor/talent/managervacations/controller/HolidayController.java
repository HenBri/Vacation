package com.dharbor.talent.managervacations.controller;

import com.dharbor.talent.managervacations.domain.dto.request.HolidayRequest;
import com.dharbor.talent.managervacations.domain.dto.response.holiday.DeleteHolidayResponse;
import com.dharbor.talent.managervacations.domain.dto.response.holiday.GetHolidaysResponse;
import com.dharbor.talent.managervacations.domain.dto.response.holiday.GetHolidaysResponseDelete;
import com.dharbor.talent.managervacations.domain.dto.response.holiday.HolidayResponse;
import com.dharbor.talent.managervacations.usecase.holiday.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Henry Aspeti
 * ShadowDevHat
 * U/J/A
 */
@RestController
@RequestMapping("/Holiday")
public class HolidayController {
    @Autowired
    private CreateHolidayUseCase createHolidayUseCase;
    @Autowired
    private DeleteAllHolidayByCountryUseCase deleteAllHolidayByCountryUseCase;
    @Autowired
    private DeleteHolidayByIdUseCase deleteHolidayByIdUseCase;
    @Autowired
    private GetHolidayByCountryUseCase getHolidayByCountryUseCase;
    @Autowired
    private GetHolidayByIdUseCase getHolidayByIdUseCase;
    @Autowired
    private UpdateHolidayUseCase updateHolidayUseCase;

    @PostMapping("Save/createHoliday{idCountry}")
    public HolidayResponse saveHoliday(@RequestBody HolidayRequest holidayRequest, @PathVariable Long idCountry){
        return createHolidayUseCase.execute(holidayRequest, idCountry);
    }
    @GetMapping("GetById/{idHoliday}")
    public HolidayResponse getHolidayById(@PathVariable Long idHoliday){
        return getHolidayByIdUseCase.execute(idHoliday);
    }
    @GetMapping("GetByCountry/{idCountry}")
    public GetHolidaysResponse getHolidayByCountry(@PathVariable Long idCountry){
        return getHolidayByCountryUseCase.execute(idCountry);
    }
    @DeleteMapping("DeleteById/{idHoliday}")
    public DeleteHolidayResponse deleteHolidayById(@PathVariable Long idHoliday){
        return deleteHolidayByIdUseCase.execute(idHoliday);
    }
    @DeleteMapping("DeleteByCountry/{idCountry}")
    public GetHolidaysResponseDelete deleteGetAllHolidayByCountry(@PathVariable Long idCountry){
        return deleteAllHolidayByCountryUseCase.execute(idCountry);
    }
    @PutMapping("UpdateHoliday/{idHoliday}")
    public HolidayResponse updateHoliday(@RequestBody HolidayRequest holidayRequest,@PathVariable Long idHoliday){
        return updateHolidayUseCase.execute(holidayRequest, idHoliday);
    }
}
