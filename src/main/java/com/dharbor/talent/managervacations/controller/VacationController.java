package com.dharbor.talent.managervacations.controller;


import com.dharbor.talent.managervacations.domain.dto.request.VacationRequest;
import com.dharbor.talent.managervacations.domain.dto.response.vacation.GetVacationsResponse;
import com.dharbor.talent.managervacations.domain.dto.response.vacation.GetVacationsResponseDelete;
import com.dharbor.talent.managervacations.domain.dto.response.vacation.VacationResponse;
import com.dharbor.talent.managervacations.domain.dto.response.vacation.VacationResponseDelete;
import com.dharbor.talent.managervacations.usecase.vacation.CreateVacationUseCase;
import com.dharbor.talent.managervacations.usecase.vacation.DeleteAllVacationByUserUseCase;
import com.dharbor.talent.managervacations.usecase.vacation.DeleteVacationByIdUseCase;
import com.dharbor.talent.managervacations.usecase.vacation.GetAllVacationByUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vacations")
public class VacationController {
    @Autowired
    private CreateVacationUseCase createVacationUseCase;
    @Autowired
    private GetAllVacationByUserUseCase getAllVacationByUserUseCase;
    @Autowired
    private DeleteAllVacationByUserUseCase deleteAllVacationByUser;
    @Autowired
    private DeleteVacationByIdUseCase deleteVacationById;

    @PostMapping("Save/{userId}")
    public VacationResponse saveVacation(@RequestBody VacationRequest vacationRequest, @PathVariable Long userId){
        return createVacationUseCase.execute(vacationRequest, userId);
    }
    @GetMapping("GetAllByUser/{userId}")
    public GetVacationsResponse getAllVacationByUser(@PathVariable Long userId){
        return  getAllVacationByUserUseCase.execute(userId);
    }
    @DeleteMapping("DeleteById/{vacationId}")
    public VacationResponseDelete deleteVacationById(@PathVariable Long vacationId){
        return deleteVacationById.execute(vacationId);
    }
    @DeleteMapping("DeleteByUser/{userId}")
    public GetVacationsResponseDelete deleteVacationByUser(@PathVariable Long userId){
        return deleteAllVacationByUser.execute(userId);
    }
}
