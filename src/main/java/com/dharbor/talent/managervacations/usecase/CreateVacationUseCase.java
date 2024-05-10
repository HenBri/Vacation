package com.dharbor.talent.managervacations.usecase;

import com.dharbor.talent.managervacations.domain.User;
import com.dharbor.talent.managervacations.domain.Vacation;
import com.dharbor.talent.managervacations.domain.dto.request.VacationRequest;
import com.dharbor.talent.managervacations.domain.dto.response.VacationReesponse;
import com.dharbor.talent.managervacations.service.IUserService;
import com.dharbor.talent.managervacations.service.IVacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class CreateVacationUseCase {
    @Autowired
    private IVacationService vacationservice;
    @Autowired
    private  IUserService userService;
    public Vacation execute(VacationRequest vacationRequest, Long userId){
        User user = userService.findById(userId);
        Vacation vacationBuild= buildVacation(vacationRequest, user);
        Vacation vacation= vacationservice.save(vacationBuild);
        return vacation;

    }

    private Vacation buildVacation(VacationRequest vacationRequest, User user){
        Vacation vacation = new Vacation();
        vacation.setVacationType(vacationRequest.getType());
        vacation.setVacationsStatus(vacationRequest.getStatus());
        vacation.setDayOff(vacationRequest.getDayOff());
        vacation.setUser(user);
        return vacation;
    }
}
