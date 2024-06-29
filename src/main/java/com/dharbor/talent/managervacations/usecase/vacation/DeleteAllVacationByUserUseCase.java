package com.dharbor.talent.managervacations.usecase.vacation;

import com.dharbor.talent.managervacations.domain.User;
import com.dharbor.talent.managervacations.domain.Vacation;
import com.dharbor.talent.managervacations.domain.dto.response.vacation.GetVacationsResponseDelete;
import com.dharbor.talent.managervacations.service.IUserService;
import com.dharbor.talent.managervacations.service.IVacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Henry Aspeti
 * ShadowDevHat
 * U/J/A
 */
@Service
public class DeleteAllVacationByUserUseCase {
    @Autowired
    private IVacationService vacationService;
    @Autowired
    private IUserService userService;

    @Transactional
    public GetVacationsResponseDelete execute(Long userId){
        User user = userService.findById(userId);
        GetVacationsResponseDelete vacationsResponse = build(user);
        vacationService.deleteAllByUser(user);
        return vacationsResponse;
    }
    private GetVacationsResponseDelete build(User user){
        List<Vacation> vacations = vacationService.getVacationByUser(user);
        return new GetVacationsResponseDelete(vacations);
    }
}
