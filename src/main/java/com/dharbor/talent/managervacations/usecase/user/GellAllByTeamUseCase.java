package com.dharbor.talent.managervacations.usecase.user;

import com.dharbor.talent.managervacations.domain.Team;
import com.dharbor.talent.managervacations.domain.User;
import com.dharbor.talent.managervacations.domain.dto.response.user.GetUsersResponse;
import com.dharbor.talent.managervacations.service.ITeamService;
import com.dharbor.talent.managervacations.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Henry Aspeti
 * ShadowDevHat
 * U/J/A
 */
@Service
public class GellAllByTeamUseCase {
    @Autowired
    private IUserService userService;
    @Autowired
    private ITeamService teamService;

    public GetUsersResponse execute(Long idTeam){
        Team team = teamService.findById(idTeam);
        List<User> users = userService.getByTeam(team);
        GetUsersResponse usersBuild = buildUsers(users);
        return usersBuild;
    }
    private GetUsersResponse buildUsers(List<User> users){
        return new GetUsersResponse(users);
    }
}
