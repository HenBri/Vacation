package com.dharbor.talent.managervacations.controller;


import com.dharbor.talent.managervacations.domain.Vacation;
import com.dharbor.talent.managervacations.domain.dto.request.VacationRequest;
import com.dharbor.talent.managervacations.domain.dto.response.VacationResponse;
import com.dharbor.talent.managervacations.usecase.CreateVacationUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vacations")
public class VacationController {
    @Autowired
    private CreateVacationUseCase createVacationUseCase;

    @PostMapping("/{userId}")
    public VacationResponse saveVacation(@RequestBody VacationRequest vacationRequest, @PathVariable Long userId){
        return createVacationUseCase.execute(vacationRequest, userId);
    }
}
