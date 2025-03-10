package com.dharbor.talent.managervacations.usecase.vacation;

import com.dharbor.talent.managervacations.common.Message;
import com.dharbor.talent.managervacations.domain.User;
import com.dharbor.talent.managervacations.domain.Vacation;
import com.dharbor.talent.managervacations.domain.dto.request.VacationRequest;
import com.dharbor.talent.managervacations.domain.dto.response.vacation.VacationResponse;
import com.dharbor.talent.managervacations.exception.BadRequestExeption;
import com.dharbor.talent.managervacations.exception.DuplicateRegistrerException;
import com.dharbor.talent.managervacations.service.IUserService;
import com.dharbor.talent.managervacations.service.IVacationService;
import com.dharbor.talent.managervacations.utils.Utils;
import jakarta.xml.bind.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class CreateVacationUseCase {
    @Autowired
    private IVacationService vacationservice;
    @Autowired
    private  IUserService userService;
    @Autowired
    private Message message;


    public VacationResponse execute(VacationRequest vacationRequest, Long userId){

        validateVacation(vacationRequest);
        try {
            User user = userService.findById(userId);
            Vacation vacationBuild= buildVacation(vacationRequest, user);
            Vacation vacation= vacationservice.save(vacationBuild);
            return buildVacationResponse(vacation);

        }catch (DataIntegrityViolationException exception){
            throw new DuplicateRegistrerException(message.getMessage("Exists.vacation.message"));
        }



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

    private void validateVacation(VacationRequest vacationRequest){
        if (Utils.isNullOrEmpty(vacationRequest.getType())) {
            throw new BadRequestExeption(message.getMessage("NotNull.vacation.date.message"));
        }
        if (Utils.isNullOrEmpty(vacationRequest.getDayOff())){
            throw new BadRequestExeption(message.getMessage("NotNull.vacation.dayOff.message"));
        }

    }
}
