package com.dharbor.talent.managervacations.usecase.vacation;

import com.dharbor.talent.managervacations.domain.User;
import com.dharbor.talent.managervacations.domain.Vacation;
import com.dharbor.talent.managervacations.domain.dto.response.GetVacationsResponse;
import com.dharbor.talent.managervacations.domain.dto.response.VacationResponse;
import com.dharbor.talent.managervacations.service.IUserService;
import com.dharbor.talent.managervacations.service.IVacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Henry Aspeti
 * ShadowDevHat
 * U/J/A
 */
@Service
public class GetAllVacationByUserUseCase {
    @Autowired
    private IVacationService vacationService;
    @Autowired
    private IUserService userService;

    public GetVacationsResponse execute(Long userId){
        User user = userService.findById(userId);
        List<Vacation> vacationsByUser = vacationService.getVacationByUser(user);
        return new GetVacationsResponse(vacationsByUser);
    }

}
