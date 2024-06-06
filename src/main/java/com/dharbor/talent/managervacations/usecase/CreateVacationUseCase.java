package com.dharbor.talent.managervacations.usecase;

import com.dharbor.talent.managervacations.domain.User;
import com.dharbor.talent.managervacations.domain.Vacation;
import com.dharbor.talent.managervacations.domain.dto.request.VacationRequest;
import com.dharbor.talent.managervacations.domain.dto.response.VacationResponse;
import com.dharbor.talent.managervacations.service.IUserService;
import com.dharbor.talent.managervacations.service.IVacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateVacationUseCase {
    @Autowired
    private IVacationService vacationservice;
    @Autowired
    private  IUserService userService;
    public VacationResponse execute(VacationRequest vacationRequest, Long userId){
        User user = userService.findById(userId);
        Vacation vacationBuild= buildVacation(vacationRequest, user);
        Vacation vacation= vacationservice.save(vacationBuild);
        return buildVacationResponse(vacation);

    }

    private Vacation buildVacation(VacationRequest vacationRequest, User user){
        Vacation vacation = new Vacation();
        vacation.setVacationType(vacationRequest.getType());
        vacation.setDayOff(vacationRequest.getDayOff());
        vacation.setUser(user);
        return vacation;
    }

    private VacationResponse buildVacationResponse(Vacation vacation){
        return new VacationResponse(vacation);
    }
}
