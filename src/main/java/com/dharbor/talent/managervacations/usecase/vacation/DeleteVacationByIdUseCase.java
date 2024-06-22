package com.dharbor.talent.managervacations.usecase.vacation;

import com.dharbor.talent.managervacations.domain.Vacation;
import com.dharbor.talent.managervacations.domain.dto.response.vacation.VacationResponseDelete;
import com.dharbor.talent.managervacations.service.IVacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Henry Aspeti
 * ShadowDevHat
 * U/J/A
 */
@Service
public class DeleteVacationByIdUseCase {
    @Autowired
    private IVacationService vacationService;

    public VacationResponseDelete execute(Long vacationId){
        VacationResponseDelete vacationResponse = build(vacationId);
        vacationService.deleteById(vacationId);
        return vacationResponse;
    }
    private VacationResponseDelete build(Long vacationId){
        Vacation vacation = vacationService.findById(vacationId);
        return new VacationResponseDelete(vacation);
    }
}
